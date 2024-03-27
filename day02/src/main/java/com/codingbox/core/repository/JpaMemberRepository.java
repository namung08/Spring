package com.codingbox.core.repository;

import com.codingbox.core.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaMemberRepository implements MemberRepository{
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
