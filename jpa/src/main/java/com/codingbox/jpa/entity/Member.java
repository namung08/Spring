package com.codingbox.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter @Setter
//@Table(name = "MBR")
//@NoArgsConstructor
public class Member {
	
	@Id
	private Long id;
	
	@Column(unique = true, length = 10)
	private String name;
	private int age;
}
















