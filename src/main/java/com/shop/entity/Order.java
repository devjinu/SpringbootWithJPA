package com.shop.entity;

import com.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 상품 주문일
    private LocalDateTime orderDate;

    // 상품 주문 상태
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    // Order 엔티티가 주인이 아니므로 mappedBy 사용, 하나의 주문이 여러 개의 주문상품을 가지므로 list
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
