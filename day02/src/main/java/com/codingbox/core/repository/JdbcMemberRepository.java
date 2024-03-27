package com.codingbox.core.repository;

import com.codingbox.core.dto.Member;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcMemberRepository implements MemberRepository{

    private String sql = "";
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private final DataSource dataSource;
    // 생성자
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        sql = "insert into member values (member_seq.nextval,?)";
        try {
            conn = dataSource.getConnection();
            String param[] = {"id"};
            pstm = conn.prepareStatement(sql,param);
            pstm.setString(1,member.getName());
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if(rs.next()) {
                member.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pstm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return member;
    }

    @Override
    public List<Member> findAll() {
        sql = "select * from member";
        List<Member> members = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                members.add(member);
                System.out.println(member.getId());
                System.out.println(member.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pstm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return members;
    }
}
