package com.example.study.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
// 로그인한 사용자를 감시
public class LoginUserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() { // 현재 감시자를 반환하는 메소드
        return Optional.of("AdminServer");
    }
}
