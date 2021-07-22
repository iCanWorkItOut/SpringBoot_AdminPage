package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    // DI(Dependency Injection) : 의존성 주입
    @Autowired // 대표적인 DI 중 하나
    private UserRepository userRepository;
    // DI를 통해 private UserRepository userRepository = new UserRepository(); 와 같이 직접 객체 생성을 하지않고
    // 스프링이 객체를 생성하여 관리하도록 할 수 있음.

    @Test // 테스트이기 때문에 테스트 어노테이션을 명시
    public void create() {
        // JPA의 Repository를 사용하면 아래와 같이 쿼리문을 직접 작성하지 않아도 CRUD와 같은 기본적인 쿼리문을 수행할 수 있다.
        // String sql = "insert into user (%s, %s) value (account, email)";
        User user = new User();
//        user.setId(); id는 아래 save 진행 시 AutoIncrement를 통해 자동 설정되므로 사용하지 않는다.
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser03");

        // save를 통하여 user인스턴스를 저장하고 newUser라는 새로운(저장된) 객체를 반환받는다.
        User newUser = userRepository.save(user); // <S extends T> S save(S entity);
        // 반환받은 newUser에는 위의 set으로 설정한 값들이 저장되고 id 또한 자동(AutoIncrement)설정 되어 있다.
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findByAccount("TestUser03");
        // Optional을 사용하여 findById의 반환값이 없을 경우(null) NullPointException을 예방할 수 있다.
        // Optinonal을 사용하지 않을 경우, User user = ......; if(user != null) {....}을 사용해야 함.

        user.ifPresent(selectUser -> { // 람다식 // user값이 User타입으로 존재할 경우(notNull) 그 값을 selectUser객체에 저장
            selectUser.getOrderDetailList().stream().forEach(detail -> {
                System.out.println(detail.getItem());
            });
        });
    }

    @Test
    @Transactional // 메소드 실행 후(모든 쿼리문을 정상적으로 수행) DB를 다시 Rollback 시켜 메소드 실행전의 상태로 되돌림
    public void update() {
        Optional<User> user = userRepository.findById(3L); // id가 3인 튜플의 값을 모두 꺼내와 user에 저장

        user.ifPresent(selectUser -> { // selectUser에 user를 복사
            selectUser.setId(2L); // id가 2로 변경됨
            selectUser.setAccount("test02");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);// 마지막으로 id를 건드렸던 2번 튜플을 불러와
            // > 불러온 2번의 값을 set으로 설정한 값으로 변경(DB반영 X)
            // > 변경된 값을 2번 튜플(where id=2)에 객체의 값으로 변경(update) : DB반영 O
            // 따라서 findById로 검색한 3번 튜플이 수정되는 것이 아니라 2번 튜플이 수정되므로,
            // update를 할 때는 ifPresent 내에서 setId와 같이 기본키값을 건드리지 않아야 한다.
        });
    }

    @Test
    @Transactional // 메소드 실행 후(모든 쿼리문을 정상적으로 수행) DB를 다시 Rollback 시켜 메소드 실행전의 상태로 되돌림
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent()); // user.isPresent()의 값이 True가 아닐 경우(null) error를 발생시킴

        user.ifPresent(selectUser -> {
            // selectUser.setId(3L); // 이 코드를 삽입하면 findById로 검색한 id가 아닌 3번이 삭제 됨.
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);
        Assertions.assertFalse(deleteUser.isPresent()); // deleteUser.isPresent()값이 true이면 error

//        if(deleteUser.isPresent()) {
//            System.out.println("데이터 존재 : " + deleteUser.get()); // get() : Optional 클래스의 메소드, <T>value!=null일 시 value 반환
//        }else {
//            System.out.println("데이터 삭제 완료");
//        }


    }

}
