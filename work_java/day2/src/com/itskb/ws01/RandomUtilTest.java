package com.itskb.ws01;

import java.util.Scanner;

public class RandomUtilTest {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println("getRandomInt1 결과값");
		for (int i = 0; i < 10; i++) {
			System.out.print(RandomUtil.getRandomInt1(a, b) + " ");
		}
		System.out.println();
		
		System.out.println("getRandomInt2 결과값");
		for (int i = 0; i < 10; i++) {
			System.out.print(RandomUtil.getRandomInt2(a, b) + " ");
		}

	}

}
