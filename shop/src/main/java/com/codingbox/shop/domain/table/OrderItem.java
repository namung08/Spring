package com.codingbox.shop.domain.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue
    private Long id;
    private int orderPrice;
    private int count;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
}
