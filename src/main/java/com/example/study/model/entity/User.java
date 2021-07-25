package com.example.study.model.entity;

//import javax.persistence.Column;
import com.example.study.model.enumclass.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
//import javax.persistence.Table;

@Data    @AllArgsConstructor    @NoArgsConstructor
@Builder // 빌더 패턴(lombok의 생성자 패턴) : 빌더를 사용하면 생성자가 없어도 원하는 조건으로 인스턴스 생성 가능
@Accessors(chain = true) // 체인접근자 패턴(lombok의 setter 패턴) : setter를 일일히 호출하지 않고 체이닝을 통해 설정 가능
@Entity // == table
@ToString(exclude = "orderGroupList")
//@Table(name = "user") 클래스명(User)와 테이블명이 같을 경우 생략 가능
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id // 식별자(Primarykey)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 어떤 식으로 관리할 것인지 자동생성 전략옵션을 설정하는 어노테이션
    private long id;
    private String account;
    private String password;

    @Enumerated(EnumType.STRING) // Enum 설정
    private UserStatus status; // REGISTERED, UNREGISTERED, WATING..

    private String email;
//    JPA에서는 SnakeCase로 된 DB의 컬럼명을 자동으로 CamelCase로 변환하여 자바와 Mapping 시켜준다.
//    DB의 컬럼명과 자바의 변수명이 다른 경우 @Table과 같이 @Column 어노테이션을 이용하여 맵핑시켜주면 된다.

//    @Column(name = "phone_number")
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

// ERD 설계 전 맵핑코드
//    // 1:N
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mappedBy : 어떤 컬럼에 맵핑시킬 것인지 -> OrderDetail에서 맵핑시키는 변수명과 일치해야 함
//    private List<OrderDetail> orderDetailList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // User:OrderGroup = 1:N
    private List<OrderGroup> orderGroupList;
}
