package com.kb.sms;

import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("복권을 살 금액을 입력하세요.");
		
		int money = sc.nextInt();
		while (money > 0) {
			for (int i = 0; i < 6; i++) {
				System.out.print(r.nextInt(45) + 1 + " "); // nextInt(int bound): 0 ~ bound - 1 범위
			}	
			money -= 1_000;
			System.out.println();
		}
		
	}

}
