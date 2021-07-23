package com.example.study.repository;

import com.example.study.model.entity.User;

// 인터페이스를 통해서, 기본적인 CRUD의 쿼리문을 직접 작성하지 않아도 사용할 수 있음.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository 사용방법
//1. 인터페이스 생성 : 일반적으로 Repository패키지를 만들어 "클래스(테이블)명"+"Repository"로 관리한다.
//2. @Repository 어노테이션을 명시
//3. JPA의 Repository 인터페이스를 상속(JpaRepository<T, ID>)

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // <T, ID> -> T : 엔티티, ID : 기본키 자료형

// ERD 설계 전 코드
//    Optional<User> findByAccount(String account); // 쿼리메소드(쿼리문을 메소드로) == (SELECT * FROM user WHERE account = ?)
//    Optional<User> findByEmail(String email);
//    // SELECT * FROM user WHERE account = ? AND email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
    User findByEmail(String email);
}
