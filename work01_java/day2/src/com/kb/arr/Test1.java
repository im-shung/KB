package com.kb.arr;

public class Test1 {

	public static void main(String[] args) {
		// 배열 
		// 1.선언
		int[] s;
		int a[];
		// 2.생성
		s = new int[5];
		int[] b = new int[5];
		
		// 3.값할당
		s[0] = 11;
		s[1] = 22;
		int[] c = {11, 22, 33, 44, 55}; // 선언, 생성 값할당 한꺼번에
		int[] d = new int[] {11, 22, 33, 44, 55};
		
		m(c);
		m(b);
//		m({11, 22, 33, 44, 55}); // 에러 
		m(new int[] {11, 22, 33, 44, 55});
		
		// 4.검색
		System.out.println(s[1]);
		System.out.println(c[0]);
		for (int cc : c) {
			System.out.println(cc + " ");
		}
	}

	public static void m(int[] s) {
		
	}
}
