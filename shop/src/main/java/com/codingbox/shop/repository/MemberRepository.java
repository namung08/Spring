package com.codingbox.shop.repository;

import com.codingbox.shop.domain.table.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}