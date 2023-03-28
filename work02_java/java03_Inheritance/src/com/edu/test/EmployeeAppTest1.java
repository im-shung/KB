package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;

/*
 * 1.객체 생성 == 클래스의 멤버를 메모리에 올린다.
 * 2.접근 
 *   1) 필드에 접근 ---> 값할당
 *   2) 메소드에 접근 ---> 호출
 */
public class EmployeeAppTest1 {

	public static void main(String[] args) {
		Manager m = new Manager("James", new MyDate(1999, 3, 24), 20_000.0, "IT");

		/*
		 * 1. eg라는 이름으로 Engineer를 생성 2. s라는 이름으로 secratary를 생성 3. Manager, Engineer,
		 * Secratary정보를 콘솔로 출력 4. Manager, Engineer, Secratary 의 연봉을 출력 5. Manager,
		 * Engineer, Secratary의 이름을 각각 출력
		 */

		Engineer eg = new Engineer("eg", new MyDate(1999, 3, 24), 5_000_000.0, "Java", 1_000_000.0);
		Secratary s = new Secratary("s", new MyDate(2, 3, 24), 4_500_000.0, "James");

		System.out.println("========== 정보를 출력합니다.=================");
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(s.getDetails());

		System.out.println("========== 연봉 정보를 출력합니다.=================");
		System.out.println("Manager 연봉" + m.getSalary() * 12 + "달러");
		System.out.println("Engineer 연봉" + eg.getSalary() * 12 + eg.getBonus() + "달러");
		System.out.println("Secratary 연봉" + s.getSalary() * 12 + "달러");

		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		System.out.println("Manager 이름" + m.getName());
		System.out.println("Engineer 이름" + eg.getName());
		System.out.println("Secratary 이름" + s.getName());
	}

}
