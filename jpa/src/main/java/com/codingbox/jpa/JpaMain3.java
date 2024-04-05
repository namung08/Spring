package com.codingbox.jpa;

import java.util.List;

import com.codingbox.jpa.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain3 {

	public static void main(String[] args) {
		EntityManagerFactory emf
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// 비영속상태
			Member member = new Member();
			member.setId(100L);
			member.setName("HelloJPA");
			
			// 여기서부터 영속 상태
			// EntityManager안에있는 영속성 컨텍스트에 관리가 된다는 뜻
			System.out.println("=====before=====");
			em.persist(member);
			System.out.println("=====after=====");
			
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
		
	}

}









