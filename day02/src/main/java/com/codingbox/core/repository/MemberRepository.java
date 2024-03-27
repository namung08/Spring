package com.codingbox.core.repository;

import com.codingbox.core.dto.Member;

import java.util.List;

public interface MemberRepository {
    // 회원 저장
    Member save(Member member);
    // 전체 찾기
    List<Member> findAll();
}
