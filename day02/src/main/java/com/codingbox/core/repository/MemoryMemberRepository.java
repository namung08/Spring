package com.codingbox.core.repository;

import com.codingbox.core.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    // 메모리를 사용
    private static Map<Integer, Member> store = new HashMap<>();
    private static int seq = 0;
    @Override
    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
