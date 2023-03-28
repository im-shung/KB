package com.edu.vo;

import com.edu.util.MyDate;

/*
 * Manager 에 대한 정보를 저장하는 클래스
 * 1. private 필드 선언
 * 2. public 값이 주입되는 통로(생성자, setter())
 * 3. public 주입된 값을 반환하는 기능
 */
public class Manager {

	// field....
	private String name;
	private MyDate birthdate;
	private double salary;
	private String dept;

	public String getDetails() {
		return name + "," + birthdate.getDate() + "," + salary + "," + dept;
	}

	public Manager() {} // 기본 생성자
	
	// ~Test클래스에서 생성자를 호출하는 시점에 값이 필드에 주입
	// 명시적 생성자
	// 값을 주입하는 통로
	public Manager(String name, MyDate birthdate, double salary, String dept) {
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
		this.dept = dept;
	}
	
	// 값을 주입하는 통로
	public void setManagerField(String name, MyDate birthdate, double salary, String dept) {
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
		this.dept = dept;
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

	public String getDept() {
		return dept;
	}

	
}
