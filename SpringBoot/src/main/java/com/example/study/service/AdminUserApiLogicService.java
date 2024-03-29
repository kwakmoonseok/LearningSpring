package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.AdminUser;
import com.example.study.model.entity.Category;
import com.example.study.model.entity.OrderGroup;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.AdminUserApiRequest;
import com.example.study.model.network.request.CategoryApiRequest;
import com.example.study.model.network.response.AdminUserApiResponse;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.model.network.response.OrderGroupApiResponse;
import com.example.study.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest body = request.getData();
        AdminUser adminUser = AdminUser.builder()
                .id(body.getId())
                .account(body.getAccount())
                .password(body.getPassword())
                .status(body.getStatus())
                .role(body.getRole())
                .lastLoginAt(body.getLastLoginAt())
                .loginFailCount(body.getLoginFailCount())
                .passwordUpdatedAt(body.getPasswordUpdatedAt())
                .registeredAt(body.getRegisteredAt())
                .unregisteredAt(body.getUnregisteredAt())
                .createdAt(LocalDateTime.now())
                .createdBy(body.getCreatedBy())
                .updatedAt(LocalDateTime.now().plusDays(1))
                .updatedBy(body.getUpdatedBy())
                .build();
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        return Header.OK(response(newAdminUser));
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return adminUserRepository.findById(id)
                .map(adminUser -> Header.OK(response(adminUser)))
                .orElseGet(() -> Header.ERROR("Data is not exist!"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest body = request.getData();
        return adminUserRepository.findById(body.getId())
                .map(adminUser -> {
                    adminUser.setId(body.getId())
                            .setAccount(body.getAccount())
                            .setPassword(body.getPassword())
                            .setStatus(body.getStatus())
                            .setRole(body.getRole())
                            .setLastLoginAt(body.getLastLoginAt())
                            .setLoginFailCount(body.getLoginFailCount())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt())
                            .setCreatedAt(body.getCreatedAt())
                            .setCreatedBy(body.getCreatedBy())
                            .setUpdatedAt(body.getUpdatedAt())
                            .setUpdatedBy(body.getUpdatedBy());
                    return adminUser;
                })
                .map(newAdminUser -> {
                    adminUserRepository.save(newAdminUser);
                    return newAdminUser;
                })
                .map(adminUser -> Header.OK(response(adminUser)))
                .orElseGet(()->Header.ERROR("Data is not exist"));
    }

    @Override
    public Header delete(Long id) {
        return adminUserRepository.findById(id)
                .map(adminUser -> {
                    adminUserRepository.delete(adminUser);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("Data is not exist"));
    }

    @Override
    public Header<List<AdminUserApiResponse>> search(Pageable pageable) {
        Page<AdminUser> adminUsers = baseRepository.findAll(pageable);

        List<AdminUserApiResponse> adminUserApiResponseList = adminUsers.stream()
                .map(adminUser -> response(adminUser))
                .collect(Collectors.toList());
        return Header.OK(adminUserApiResponseList);
    }

    private AdminUserApiResponse response(AdminUser adminUser){
        AdminUserApiResponse body = AdminUserApiResponse.builder()
                .id(adminUser.getId())
                .account(adminUser.getAccount())
                .password(adminUser.getPassword())
                .status(adminUser.getStatus())
                .role(adminUser.getRole())
                .lastLoginAt(adminUser.getLastLoginAt())
                .loginFailCount(adminUser.getLoginFailCount())
                .passwordUpdatedAt(adminUser.getPasswordUpdatedAt())
                .registeredAt(adminUser.getRegisteredAt())
                .unregisteredAt(adminUser.getUnregisteredAt())
                .createdAt(adminUser.getCreatedAt())
                .createdBy(adminUser.getCreatedBy())
                .updatedAt(adminUser.getUpdatedAt())
                .updatedBy(adminUser.getUpdatedBy())
                .build();
        return body;
    }
}
