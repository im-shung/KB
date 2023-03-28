package com.edu.test;

/*
 final 
 
 <<access modifier>>
 	public / protected / final
 	ex) static final int SPEED;
 		final static int SPEED;
 		
 final "내가 마지막이야~~~"
 final + 변수 ==> "내가 마지막 변수야~~~" 상수
 final + 클래스 ==> "내가 마지막 클래스야~~~~" 상속금지
 final + 메소드 ==> "내가 마지막 메소드야~~~~" Overriding 금지
 */

class SuperAA {
	public static final int BASIC_SALARY = 300_000_000; // 상수
	public final String test() {
		return "Overriding 금지";
	}
}

final class supserA { // 상속금지
	
}

//class Child extends SuperA {
//	
//}
class ChildA extends SuperAA{
	// BASIC_SALARY = 100_000; // 값변경 안됨
	
//	public final String test() {
//		String name = "James";
//		return name;
//	}
}
public class FinalExamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
