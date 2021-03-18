package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.Category;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.CategoryApiRequest;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryApiLogicService implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
        CategoryApiRequest body = request.getData();
        Category category = Category.builder()
                .id(body.getId())
                .type(body.getType())
                .title(body.getTitle())
                .createdAt(LocalDateTime.now())
                .createdBy(body.getCreatedBy())
                .updatedAt(LocalDateTime.now().plusDays(1))
                .updatedBy(body.getUpdatedBy())
                .build();
        Category newCategory = categoryRepository.save(category);
        return response(newCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return categoryRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("Data is not exist!"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
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

    private Header<CategoryApiResponse> response(Category category){
        CategoryApiResponse body = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .createdAt(category.getCreatedAt())
                .createdBy(category.getCreatedBy())
                .updatedAt(category.getUpdatedAt())
                .updatedBy(category.getUpdatedBy())
                .build();
        return Header.OK(body);
    }
}
