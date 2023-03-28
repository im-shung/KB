package com.edu.vo;

import com.edu.util.MyDate;

public class Secratary extends Employee {

	private String bossOfName;

	// 기본 생성자
	public Secratary() {
	}

	public Secratary(String name, MyDate birthdate, double salary, String bossOfName) {
		// 무조건 부모 생성이 무조건 일어난다.
		super(name, birthdate, salary);
		this.bossOfName = bossOfName;
	}
	
	@Override
	public String getDetails() {
		
		return super.getDetails() + "," + bossOfName;
	}
	
}
