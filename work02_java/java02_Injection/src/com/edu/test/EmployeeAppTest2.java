package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;

/*
 * Manager타입의 배열을 생성
 * 이 안에 여러 명의 Manager객체를 넣고
 * 한번에 핸들링할 수 있는 코드를 작성
 */
public class EmployeeAppTest2 {

	public static void main(String[] args) {
		Manager[] managers = {
				new Manager("James", new MyDate(1999, 3, 24), 20_000.0, "IT"),
				new Manager("Gosling", new MyDate(2000, 11, 13), 20_000.0, "Maketing"),
				new Manager("Peter", new MyDate(1998, 5, 3), 20_000.0, "IT")
		};
		
		System.out.println("========== 정보를 출력합니다.=================");
		for (Manager m : managers) System.out.println(m.getDetails());

		System.out.println("\n========== 연봉 정보를 출력합니다.=================");
		for (Manager m : managers) System.out.println(m.getSalary() * 12 + "달러");
		
		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		for (Manager m : managers) System.out.println("Manager 이름"+ m.getName());

	}

}
