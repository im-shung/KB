package com.kb.algo;

// 1~10까지 출력해 보자
public class RecursiveTest {

	public static void main(String[] args) {
		recursive(1);
	}

	private static void recursive(int su) {
		if (su > 10) return;
		System.out.println(su);
		recursive(su + 1);
		
	}
}
