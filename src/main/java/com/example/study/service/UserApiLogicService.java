package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 자바 클래스는 서비스로 동작하게 됨
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data 가져오기
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    public Header<UserApiResponse> read(long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    public Header delete(long id) {
        return null;
    }
}
