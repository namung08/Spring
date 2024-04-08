package com.codingbox.jpaitem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue        // 전략 생성하면 AUTO 이다.
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	public void addOrder(Order order) {
		order.setMember(this);
		this.orders.add(order);
	}

	public Member(String name, String city, String street, String zipcode) {
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}