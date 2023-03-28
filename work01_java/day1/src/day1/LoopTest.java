package day1;

import java.util.Arrays;

public class LoopTest {

	public static void main(String[] args) {
		// for
		for (int i = 0; i < 10; i++) {
			System.out.println("****");
		}

		int dan = 3;
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
		System.out.println();
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
			System.out.println();
		}

		// for ~ each
		int[] su = { 30, 70, 20, 80, 10 };
		System.out.println(Arrays.toString(su));
		for (int i = 0; i < su.length; i++) { // 배열명.length -> 배열의 길이
			System.out.print(su[i] + " ");
		}
		System.out.println(); // 줄바꿈 \n, \t
		for (int val : su) {
			System.out.print(val + " ");
		}
		/* 여러 줄 주석
		// while
		while (조건) {
			// 참인동안 수행할 문장
			
		}  
		// do ~ while
		do {
			// 작업
		} while (조건); // 조건이 참이면 do에서 반복 
		*/
		
		
	} // end of main

} // end of class