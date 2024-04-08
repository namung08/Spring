package com.codingbox.jpaitem.domain.repository;

import com.codingbox.jpaitem.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}