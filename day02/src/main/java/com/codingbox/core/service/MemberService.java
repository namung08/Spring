package com.codingbox.core.service;

import com.codingbox.core.dto.Member;
import com.codingbox.core.repository.JdbcMemberRepository;
import com.codingbox.core.repository.JpaMemberRepository;
import com.codingbox.core.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    JpaMemberRepository jpaMemberRepository;

    public MemberService(JpaMemberRepository jpaMemberRepository) {
        this.jpaMemberRepository = jpaMemberRepository;
    }

    // 회원가입
    public int join(Member member){
        jpaMemberRepository.save(member);
        return member.getId();
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        return jpaMemberRepository.findAll();
    }
}
