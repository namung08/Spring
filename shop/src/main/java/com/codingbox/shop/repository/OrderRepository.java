package com.codingbox.shop.repository;

import com.codingbox.shop.domain.Order;
import com.codingbox.shop.dto.OrderSearch;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    // 검색, 전체 조회, QueryDSL - 실무에서 많이 사용
    public List<Order> findAll(OrderSearch search) {
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findOrders(){
        return null;
    }
}
