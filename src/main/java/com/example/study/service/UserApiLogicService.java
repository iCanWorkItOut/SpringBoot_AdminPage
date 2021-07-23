package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service // 해당 자바 클래스는 서비스로 동작하게 됨
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data 가져오기
    // 2. User 생성
    // 3. 생성된 데이터 -> UserApiResponse : return // CRUD 메서드에서 Header<UserApiResponse> 를 반환하므로 따로 메서드로 만들어 줌.
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data 가져오기
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> UserApiResponse : return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(long id) {

//        // 1. id -> repository getOne, getById
//        Optional<User> optional = userRepository.findById(id);
//
//        // 2. user -> userApiResponse : return
//        return optional
//                .map(user -> response(user))
//                .orElseGet(
//                        () -> Header.ERROR("데이터 없음")
//                );

        // 위 1, 2를 합친 코드
        return userRepository.findById(id).map(user -> response(user)).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(long id) {
        return null;
    }

    private  Header<UserApiResponse> response(User user) {
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);
    }
}
