package com.codingbox.jpa.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Member2 {
	@Id
	private Long id;
	
	@Column(unique = true, length = 10)
	private String name;
	
	// 컬럼명 지정
	@Column(name = "myage")
	private int age;
	
	/**
	 * Date : java.sql.Date 	- jpa : TIME, TIMESTAMP(X)
	 * Date : java.util.Date	- jpa : TIME, TIMESTAMP(O)
	 */
	
	// 날짜 타입 매핑
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	// 날짜 타입 매핑
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModiredDate;
	
	// 매핑무시
	@Transient
	private int temp;
	
}











