package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        //1. request data 가져오기
        UserApiRequest userApiRequest = request.getData();
        //2. user 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);
        //3.생성된 데이터 -> userApiResponse return
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        //id -> repository get으로 데이터 가져옴
        return userRepository.findById(id)
                .map(user -> Header.OK(response(user)))
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1. data 가져오기
        UserApiRequest userApiRequest = request.getData();
        //2. 가져온 id로 찾을 user 특정
        Optional<User> optional = userRepository.findById(userApiRequest.getId());
        return optional.map(user -> {
            //3. update
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
            //4. userApiResponse
            return user;
        })
                .map(user -> userRepository.save(user))
                .map(user -> Header.OK(response(user)))
                .orElseGet(() -> Header.ERROR("Data is not exist!"));
    }

    @Override
    public Header delete(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional.map(user -> {
            userRepository.delete(user);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("Data is not exist!"));
    }

    public Header<List<UserApiResponse>> search(Pageable pageable){
        Page<User> users = userRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList = users.stream()
                .map(user -> response(user))
                .collect(Collectors.toList());
        return Header.OK(userApiResponseList);
    }

    private UserApiResponse response(User user){
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) //그대로 리턴하지 않고, 암호화나 길이 리턴
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();
        return userApiResponse;
    }
}
