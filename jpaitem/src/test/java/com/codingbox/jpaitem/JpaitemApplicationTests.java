package com.codingbox.jpaitem;

import com.codingbox.jpaitem.relration.Member;
import com.codingbox.jpaitem.relration.Team;
import com.codingbox.jpaitem.relration.repository.TeamRepository;
import com.codingbox.jpaitem.relration.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.hibernate.FlushMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
class JpaitemApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Test
	void contextLoads() {
//		List<Member> list = memberRepository.findAll();
//		for (Member m : list) {
//			System.out.println("member = " + m.getTeam().getName());
//		}

//		 양방향 매핑 시 가장 많이 하는 실수
//		Member member = new Member();
//		member.setName("member1111111");
//		memberRepository.save(member);
//		Team team = new Team();
//		team.setName("team111111111");
//		team.getMember().add(member);
//		teamRepository.save(team);

		// jpa main3
		// 수정
//		for (int i = 0; i<10; i++) {
//			Team team = new Team();
//			team.setName("team"+i);
//			teamRepository.save(team);
//			Member member = new Member();
//			member.setName("member"+i);
//			member.changeTeam(team);
//			memberRepository.save(member);
//		}


		Optional<Team> findTeam = teamRepository.findById(1L);
		List<Member> members = findTeam.get().getMember();
		for(Member m : members) {
			System.out.println("m = "+ m.toString() );
		}

	}
}

