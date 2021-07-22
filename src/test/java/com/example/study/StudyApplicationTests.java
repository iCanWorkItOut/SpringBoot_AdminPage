package com.example.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudyApplicationTests { // 접근제어자 설정이 안되어 있어(기본 protected로 설정 됨) 상속을 받아 테스트를 하려면 public으로 변경해야 함.

    @Test
    void contextLoads() {
    }

}
