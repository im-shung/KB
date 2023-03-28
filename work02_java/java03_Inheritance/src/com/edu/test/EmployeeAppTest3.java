package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;

/*
 * Employee타입의 배열을 생성
 * 이 안에 여러 명의 Manager, Engineer, Secratary객체를 넣고
 * 부모타입으로 단일하게 이기종간의 객체들을 핸들링할 수 있는 코드를 작성
 * ::
 * Heterogenous Collection(상속덕분)
 */
public class EmployeeAppTest3 {

	public static void main(String[] args) {
		Employee[] emps = {
				new Manager("James", new MyDate(1999, 3, 24), 20_000.0, "IT"),
				new Engineer("Gosling", new MyDate(2000, 11, 13), 20_000.0, "python", 100.0),
				new Manager("Peter", new MyDate(1998, 5, 3), 20_000.0, "IT"),
				new Secratary("Juliet", new MyDate(1998, 5, 3), 20_000.0, "Gosling"),
				new Manager("Tom", new MyDate(1998, 5, 3), 20_000.0, "IT"),

		};
		
		System.out.println("========== 정보를 출력합니다.=================");
		for (Employee e : emps) System.out.println(e.getDetails());

		System.out.println("\n========== 연봉 정보를 출력합니다.=================");
		for (Employee e : emps) {
			
			if (e instanceof Engineer) { //Employee타입으로 생성된 객체가 Engineer 라면
				Engineer eg = (Engineer) e;
				System.out.println(e.getName() + " 님의 연봉은 " + (e.getSalary() * 12 + eg.getBonus()) +"달러입니다.");
			} else {
				System.out.println(e.getName() + " 님의 연봉은 " + e.getSalary() * 12 + "달러입니다.");
			}
		
		}
		
		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		for (Employee e : emps) System.out.println("Manager 이름"+ e.getName());

	}

}
