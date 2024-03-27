package com.codingbox.core.repository;

import com.codingbox.core.dto.Member;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcMemberRepository implements MemberRepository{
    private final DataSource dataSource;
    // 생성자
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
