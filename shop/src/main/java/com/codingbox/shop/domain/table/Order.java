package com.codingbox.shop.domain.table;

import com.codingbox.shop.domain.OrderStastus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    // 주문 시간
    private LocalDateTime orderDate;
    // 주문 상태 (order, cancle)
    @Enumerated
    private OrderStastus status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    // 연관 관계 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this);
        orderItems.add(orderItem);
    }
}
