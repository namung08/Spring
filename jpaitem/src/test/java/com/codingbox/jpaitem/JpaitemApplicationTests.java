package com.codingbox.jpaitem;

import com.codingbox.jpaitem.embeded.Address;
import com.codingbox.jpaitem.embeded.Member;
import com.codingbox.jpaitem.embeded.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(false)
class JpaitemApplicationTests {
	@Autowired
	MemberRepository memberRepository;
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


//		Optional<Team> findTeam = teamRepository.findById(1L);
//		List<Member> members = findTeam.get().getMember();
//		for(Member m : members) {
//			System.out.println("m = "+ m.toString() );
//		}
//
//	}
		//04-08
//		Member member = new Member();
//		member.setName("user");
//		member.setAddress(new Address("seoul","gangnam","123"));
//		member.setPeriod(new Period(LocalDateTime.now(),LocalDateTime.now().plusDays(10)));
//		memberRepository.save(member);
		Address addr = new Address("서울","강남","123");
		Member member = new Member();
		member.setName("user1");
		member.setAddress(addr);
		memberRepository.save(member);
		Member member1 = new Member();
		Address copyaddr = new Address(addr.getCity(), addr.getStreet(), addr.getZipcode());
		member1.setName("user2");
		member1.setAddress(copyaddr);
		memberRepository.save(member1);
	}
}

