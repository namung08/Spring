package com.codingbox.core.service;

import com.codingbox.core.member.Member;
import com.codingbox.core.repository.MemberRepository;
import com.codingbox.core.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    MemberRepository memberRepository = new MemoryMemberRepository();
    // 회원가입
    public int join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }
    // 전체 회원 조회
    public List<Member> findMember() {
        return memberRepository.findAll();
    }
}
