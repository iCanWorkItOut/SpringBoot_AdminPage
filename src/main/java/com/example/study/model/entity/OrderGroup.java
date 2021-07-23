package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor    @AllArgsConstructor    @Data
@Builder
@Accessors(chain = true)
@ToString(exclude = {"user", "orderDetailList"})
@Entity
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    @ManyToOne // OrderGroup N : 1 User
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup") // OrderGroup 1 : N OrderDetail
    private List<OrderDetail> orderDetailList;
}
