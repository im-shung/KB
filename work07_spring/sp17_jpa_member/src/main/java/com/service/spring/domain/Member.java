package com.service.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// VO의 정보를 table과 Mapping :: ORM

@Entity
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "id")
	private String id; // pk

	@Column(nullable = false) // nullable의 default는 true
	private String password;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String address;

	public Member() {
	}

	public Member(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	// getter, setter도 추가
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
