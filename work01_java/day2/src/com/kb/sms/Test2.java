package com.kb.sms;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		Random r = new Random();

		for (int i = 0; i < 6; i++) {
			System.out.print(r.nextInt(45) + 1 + " "); // nextInt(int bound): 0 ~ bound - 1 범위
		}
	}

}