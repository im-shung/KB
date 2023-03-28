package com.edu.vo;

import com.edu.util.MyDate;

public class Secratary extends Employee {

	private String bossOfName;

	// 기본 생성자
	public Secratary() {
	}

	public Secratary(int empId, String name, MyDate birthdate, double salary, String bossOfName) {
		// 무조건 부모 생성이 무조건 일어난다.
		super(empId, name, birthdate, salary);
		this.bossOfName = bossOfName;
	}
	
	// Employee의 toString()를 다시 정의
	@Override
	public String toString() {
		return super.toString();
	}
		
}
