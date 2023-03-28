package com.edu.vo;

import com.edu.util.MyDate;

// 부모 클래스, Super class, Parent Class
public class Employee {

	// 필드를 하나 추가
	private int empId;
	private String name;
	private MyDate birthDate;
	private double salary;


	//상수값
	public static final double BASIC_SALARY = 100;
	
	public Employee() {}
	
	public Employee(int empId, String name, MyDate birthDate, double salary) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.empId = empId;
	}
	
	
	/*
	 * this
	 * 1) local variable과 field의 이름이 동일할 때 구분하기 위해서 필드 앞에 붙인다.
	 * 2) this()---> 하나의 클래스에서 또다른 생성자를 호출할 때 사용함
	 */
	public Employee(String name, MyDate birthDate, int empId) {
		this(empId, name, birthDate, BASIC_SALARY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public void changetSalary(double salary) {
		this.salary = salary;
	}

//	public String getDetails() {
//		return name + "," + birthDate.getDate() + "," + salary;
//		
//	}
	
	public int getEmpId() {
		return empId;
	}

	@Override
	public String toString() {
		return empId + "," + name + "," + birthDate + "," + salary;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
