package com.codingbox.shop.repository;

import com.codingbox.shop.domain.Order;
import com.codingbox.shop.domain.OrderStatus;
import com.codingbox.shop.domain.QMember;
import com.codingbox.shop.domain.QOrder;
import com.codingbox.shop.dto.OrderSearch;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
        JPAQueryFactory query = new JPAQueryFactory(em);
        QOrder order = QOrder.order;
        QMember member = QMember.member;
        // order을 선택함
        return query.select(order)
                // order 테이블에서 부터
                .from(order)
                // 테이블 join
                .join(order.member, member)// 두번째 파라미터는 알리아스
                // 조건 절(메서트를 통해 값 호출 가능)
                // 직접 작성하는 조건문
//              .where(order.order_status.eq(search.getStatus()),member.name.like(search.getMemberName()))
                // 조건을 미리 선언여 값만 넣어주면 됨
                .where(orderStatusEq(search.getStatus()),memberNameLike(search.getMemberName()))
                // ArrayList 로 리턴
                .fetch();
    }
    // 조건문을 미리 선언
    private BooleanExpression orderStatusEq(OrderStatus orderStatus) {
        if (orderStatus == null) {
            return null;
        }
        // 위의 조건을 대신 하기 위해서 만든 메서드
        return QOrder.order.order_status.eq(orderStatus);
    }

    private BooleanExpression memberNameLike(String name) {
        if (name == null) {
            return null;
        }
        return QMember.member.name.like(name);
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }
}
