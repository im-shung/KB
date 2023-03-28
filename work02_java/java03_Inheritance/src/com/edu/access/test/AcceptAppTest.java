package com.edu.access.test;

import com.edu.access.parent.*;

class Child extends Parent {
	public void test() {
		// publicVar는 서로 다른 클래스, 서로 다른 패키지라도 접근 허용
		System.out.println(publicVar);
		
		// protectedVar는 Child, Parent가 상속관계...public하고 동일한 효과
		System.out.println(protectedVar);
		
		// 같은 디렉토리(패키지)에 있어야지만 접근 가능.. access/parent | access.test
//		System.out.println(var);
		
		
	}
}

public class AcceptAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
