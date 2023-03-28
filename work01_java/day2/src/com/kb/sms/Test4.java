package com.kb.sms;

import java.util.Random;
import java.util.Scanner;

public class Test4 {
	static Random r = new Random();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("복권을 살 금액을 입력하세요.");

		int money = sc.nextInt();
		int count = money / 1_000;
		for (int i = 0; i < count; i++) {
			getNumber();	
		}
	}

	// 임의의 숫자 6개 출력
	public static void getNumber() {
		for (int i = 0; i < 6; i++) {
			System.out.print(r.nextInt(45) + 1 + " "); // nextInt(int bound): 0 ~ bound - 1 범위
		}
		System.out.println();
	}

}
