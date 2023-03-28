package com.kb.sms;

public class Test {

	public static void main(String[] args) {
		// 사용1
		Student s = new Student(); // new 키워드. 
		s.num = 1001;
		s.name = "kim";
		s.study();
		s.work(2);
		Student s2 = new Student();
		s2.num = 1002;
		s2.name = "Lee";
		s2.study();
		s2.work(5);
		
		/*
		 * 1) Student s
		 * 2) new Student(); 
		 * 3) s에 new Student()가 대입 
		 * 메모리 로딩 by 클래스 로더 
		 */

	}

}
