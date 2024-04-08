package com.codingbox.jpaitem.domain.repository;

import com.codingbox.jpaitem.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}