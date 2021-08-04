package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderGroup;
import com.example.study.model.enumclass.OrderType;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.OrderGroupApiRequest;
import com.example.study.model.network.response.OrderGroupApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderGroupRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create() {

        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType(OrderType.ALL);
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");
//        orderGroup.setUserId(1L); // -> User

        Assertions.assertNotNull(orderGroupRepository.save(orderGroup));
    }

    @Test
    public void read() {
        Optional<OrderGroup> optional = orderGroupRepository.findById(1L);
//        optional.ifPresentOrElse(orderGroup -> {
//            System.out.println(orderGroup);
//        }, () -> System.out.println("데이터 없음"));
        optional.ifPresentOrElse(System.out::println, () -> System.out.println("데이터 없음"));

        List<OrderGroup> orderGroupList = orderGroupRepository.findAll();
        orderGroupList.forEach(System.out::println);
    }

}
