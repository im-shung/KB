package com.edu.test;
/*
 * Polymorphism
 * Poly + Morphism
 * ::
 * 여러가지 모양과 모습을 가지는 능력
 * 부모타입으로 여러가지 자식 클래스 객체 생성
 */


import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;

public class EmployeePolyAppTest1 {
	public static void main(String[] args) {	
		Employee m = new Manager(1, "James",new MyDate(1990,3,24),200002.0,"IT");
		Employee eg = new Engineer(2,"Gosling", new MyDate(1990,2,24),150.0,"python", 100);
		Employee s = new Secratary(3, "Juliet", new MyDate(1990,1,24),350002.0,"Gosling");

		/*
		 * Virtual Method Invocation 원리가 작동
		 * 1. 컴파일 시점의 메소드 -- Employee 의 toString() 호출 
		 * 2. 실행 시점의 메소드가 -- 실질적으로 생성된 자식클래스의 toString()을 호출
		 * 상속관계로 이어진 클래스 사이에 Overriding 된 메소드에서 발생하는 원리
		 * 여기서 Virtual Method는 가상의 메소드로...자식의 메소드를 일컫는다.
		 */
		// Employee@의 toString() 호출...
		System.out.println(m.toString());

		System.out.println(eg);
		System.out.println(s);
		
		System.out.println("\n================================");
		
		// Manager의 부서를 Maketing 부서로 변경하기
		// changeDept() m 즉, Employee타입에서는 못한다.
		Manager manager = (Manager) m;
		manager.changeDept("Maketing");
		
		((Manager) m).changeDept("Maketing");
		System.out.println(m);
		

	}
}




























