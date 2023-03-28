package com.itskb.ws03.dto;

public class UserDto {

	private int userSeq;
	private String name;
	private String email;
	private String phone;
	private boolean isSleep;

	public UserDto() {

	}

	public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}

	public int getUserSeq() {
		return userSeq;
	}
	public String toString() {
		return "고객 일련번호 : " + userSeq + "\n이름 : " + name + "\n이메일 : " + email + "\n연락처 : " + phone + "\n휴면고객여부 : " + isSleep;
	}
}
