package com.edu.vo;

import com.edu.util.MyDate;

public class Secratary {

	// field....
	private String name;
	private MyDate birthdate;
	private double salary;
	private String bossOfName;

	// 기본 생성자
	public Secratary() {} 
	
	// ~Test클래스에서 생성자를 호출하는 시점에 값이 필드에 주입
	// 명시적 생성자
	// 값을 주입하는 통로
	public Secratary(String name, MyDate birthdate, double salary, String bossOfName) {
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
		this.bossOfName = bossOfName;
	}

	public String getDetails() {
		return name + "," + birthdate.getDate() + "," + salary + "," + bossOfName;
	}

	public String getName() {
		return name;
	}

	public MyDate getBirthdate() {
		return birthdate;
	}

	public double getSalary() {
		return salary;
	}

	public String getBossOfName() {
		return bossOfName;
	}
	


}
