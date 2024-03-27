package com.codingbox.core.service;

import com.codingbox.core.member.Member;
import com.codingbox.core.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public int join(Member member){
        memberRepository.save(member);
        return member.getId();
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
}
