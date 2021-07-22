package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor    @AllArgsConstructor    @Data
@ToString(exclude = {"user", "orderDetailList"})
@Entity
public class OrderGroup {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private String orderType;
    private String revAddress;
    private String revName;
    private String paymentType;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    @ManyToOne // OrderGroup N : 1 User
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup") // OrderGroup 1 : N OrderDetail
    private List<OrderDetail> orderDetailList;
}
