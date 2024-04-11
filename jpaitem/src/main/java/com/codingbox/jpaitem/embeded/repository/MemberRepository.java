package com.codingbox.jpaitem.embeded.repository;

import com.codingbox.jpaitem.embeded.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}