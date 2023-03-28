package com.edu.vo;

import com.edu.util.MyDate;

/*
 * 1. private 필드 선언
 * 2. 값이 주입되는 통로
 *    public 명시적 생성자
 *    public void setter()
 * 3. public 주입된 값을 반환하는 기능을 정의
 * 
 * name, birthDate, salary, mainSkill, bonus --> 5
 */
public class Engineer {

	private String name;
	private MyDate birthDate;
	private double salary;
	private String mainSkill;
	private double bonus;

	public Engineer() {}
	
	public Engineer(String name, MyDate birthDate, double salary, String mainSkill, double bonus) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.mainSkill = mainSkill;
		this.bonus = bonus;
	}

	public String getDetails() {
		return name + "," + birthDate.getDate() + "," + salary + "," + mainSkill + "," + bonus;
	}

	public String getName() {
		return name;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public String getMainSkill() {
		return mainSkill;
	}

	public double getBonus() {
		return bonus;
	}
	
}
