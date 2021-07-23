package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data    @AllArgsConstructor    @NoArgsConstructor
@ToString(exclude = {"orderGroup", "item"})
@Entity // order_detail
//// 롬복 사용시 ToString메소드가 모든 변수를 참조하게 되는데,
//// 관계 맵핑 때문에 선언한 User, Item 객체 역시 참조하게 되어, 서로 상호참조하게 됨.
//// 이후 ToString 메소드를 호출하게되면 상호참조로 인한 오버플로우가 발생하게 되므로,
//// @ToString 어노테이션을 통해 ToString()에서 user, item을 참조하지 않도록 제거해주어야 함.
//// 롬복의 ToString() 오버라이딩 시 참조할 변수를 제거하는 방법은 exclude를 사용
//@ToString(exclude = {"user", "item"}) // 연관관계 설정에 대한 변수에 대해서는 exclude 해주는게 좋다.(최소 한쪽에서는 제거해줘야 상호참조x)
public class OrderDetail {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private LocalDateTime arrivalDate;
    private int quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
//    private long itemId;
//    private long orderGroupId;

// ERD 설계 전 맵핑 코드
//    // OrderDetail의 입장에서 기술
////    private long userId; // OrderDetail이 N이고 User가 1인 관계
////    private long itemId; // OrderDetail이 N이고 Item이 1인 관계
//    @ManyToOne // N:1
//    private User user; // JPA연관관계 맵핑 시에는 해당 객체를 직접 맵핑해줘야 함(long userId가 아닌 User user) // user_id
//    @ManyToOne
//    private Item item;

    @ManyToOne // OrderDetail N : 1 OrderGroup
    private OrderGroup orderGroup;

    @ManyToOne // OrderDetail N : 1 Item
    private Item item;
}
