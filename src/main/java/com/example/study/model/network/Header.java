package com.example.study.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Header<T> {

    // api 통신시간
    // @JsonProperty("transaction_time") // @JsonProperty : JSON타입을 생성할 때 변수명을 변경함(RestAPI 통신을 위해 스네이크케이스)
    // 모든 변수에 대해서 일일이 명시해주기 어렵기 때문에, resources->application.properties를 통해 설정해준다.
    private LocalDateTime transactionTime; // 프론트와 통신할 때는 일반적으로 String을 사용, default는 LDT // ISO, YYYY-MM-DD hh:mm:ss 등 다양한 규격 존재
    // api 응답 코드
    private String resultCode;
    // api 부가 설명
    private String description;

    private T data; // 통신에서 요청하는 API에 따라 전달하는 데이터가 다르기 때문에 제너릭으로 선언

    // OK
    public static <T> Header<T> OK() {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data) {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    // ERROR
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
