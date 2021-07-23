package com.example.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 설정파일에 관한 것이 들어감을 지정
@EnableJpaAuditing // JPA 감시 활성화
public class JpaConfig {

}
