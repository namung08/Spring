package com.codingbox.jpa.entity;

import com.zaxxer.hikari.util.ClockSource.Factory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
//@NoArgsConstructor
@SequenceGenerator(
	name = "MEMBER3_SEQ_GENERATOR",
	sequenceName = "MEMBER3_SEQ",	// db에 생성되는 seq이름
	initialValue = 1, allocationSize = 1
)
public class Member3 {
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "MEMBER3_SEQ_GENERATOR"
	)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String username;
	
}





