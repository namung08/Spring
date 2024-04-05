package com.codingbox.jpaitem;

import com.codingbox.jpaitem.relration.Member;
import com.codingbox.jpaitem.relration.Team;
import com.codingbox.jpaitem.relration.repository.TeamRepository;
import com.codingbox.jpaitem.relration.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
class JpaitemApplicationTests {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Test
	void contextLoads() {
//		for (int i = 0; i<10; i++) {
//			String name = "임현민"+i;
//			//given
//			Member member = new Member();
//			Team team = new Team();
//			team.setName("gusals"+i);
//			teamRepository.save(team);
//			member.setName(name);
//			member.setTeam(team);
//			memberRepository.save(member);
//		}
	}
}

