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

@Data    @AllArgsConstructor    @NoArgsConstructor
@Builder
@Accessors(chain = true)
@ToString(exclude = {"orderDetailList", "partner"})
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private String name;
    private String title;
    private String content;
    private BigDecimal price;
    private String brandName;
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

// ERD 설계 전 맵핑 코드
//    // fetch 타입 : LAZY = 지연로딩, EAGER = 즉시로딩
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;

    @ManyToOne
    private Partner partner;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item") // Item 1 : N OrderDetail
    private List<OrderDetail> orderDetailList;
}
