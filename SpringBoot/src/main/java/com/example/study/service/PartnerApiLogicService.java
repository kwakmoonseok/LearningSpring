package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.Category;
import com.example.study.model.entity.Partner;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.CategoryApiRequest;
import com.example.study.model.network.request.PartnerApiRequest;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.model.network.response.PartnerApiResponse;
import com.example.study.repository.CategoryRepository;
import com.example.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PartnerApiLogicService implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
        PartnerApiRequest body = request.getData();
        Partner partner = Partner.builder()
                .id(body.getId())
                .name(body.getName())
                .status(body.getStatus())
                .address(body.getAddress())
                .callCenter(body.getCallCenter())
                .partnerNumber(body.getPartnerNumber())
                .businessNumber(body.getBusinessNumber())
                .ceoName(body.getCeoName())
                .registeredAt(LocalDateTime.now())
                .unregisteredAt(LocalDateTime.now().plusDays(3))
                .createdAt(LocalDateTime.now())
                .createdBy(body.getCreatedBy())
                .updatedAt(LocalDateTime.now().plusDays(1))
                .updatedBy(body.getUpdatedBy())
                .category(categoryRepository.getOne(body.getCategoryId()))
                .build();
        Partner newPartner = partnerRepository.save(partner);
        return response(partner);
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {
        return categoryRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("Data is not exist!"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        CategoryApiRequest body = request.getData();
        return categoryRepository.findById(body.getId())
                .map(category -> {
                    category.setId(body.getId())
                            .setType(body.getType())
                            .setTitle(body.getTitle())
                            .setCreatedAt(body.getCreatedAt())
                            .setCreatedBy(body.getCreatedBy())
                            .setUpdatedAt(body.getUpdatedAt())
                            .setUpdatedBy(body.getUpdatedBy());
                    return category;
                })
                .map(newCategory -> {
                    categoryRepository.save(newCategory);
                    return newCategory;
                })
                .map(this::response)
                .orElseGet(()->Header.ERROR("Data is not exist"));
    }

    @Override
    public Header delete(Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("Data is not exist"));
    }

    private Header<PartnerApiResponse> response(Partner partner){
        PartnerApiResponse body = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .createdAt(partner.getCreatedAt())
                .createdBy(partner.getCreatedBy())
                .updatedAt(partner.getUpdatedAt())
                .updatedBy(partner.getUpdatedBy())
                .categoryId(partner.getCategory().getId())
                .build();
        return Header.OK(body);
    }
}
