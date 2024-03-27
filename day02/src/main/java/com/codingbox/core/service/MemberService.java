package com.codingbox.core.service;

import com.codingbox.core.dto.Member;
import com.codingbox.core.repository.JdbcMemberRepository;
import com.codingbox.core.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    JdbcMemberRepository jdbcMemberRepository;

    public MemberService(JdbcMemberRepository jdbcMemberRepository) {
        this.jdbcMemberRepository = jdbcMemberRepository;
    }

    // 회원가입
    public int join(Member member){
        jdbcMemberRepository.save(member);
        return member.getId();
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        return jdbcMemberRepository.findAll();
    }
}
