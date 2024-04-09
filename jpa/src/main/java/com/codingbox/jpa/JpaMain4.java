package com.codingbox.jpa;

import java.util.List;

import com.codingbox.jpa.entity.Member;
import com.codingbox.jpa.entity.Member3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain4 {

	public static void main(String[] args) {
		EntityManagerFactory emf
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// 비영속상태
			Member3 member = new Member3();
//			member.setId("ID_A");
			member.setUsername("HelloJPASEQ");
			
			// 영속상태
			em.persist(member);
			
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}









