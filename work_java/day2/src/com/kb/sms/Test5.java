package com.kb.sms;

import java.util.Random;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// 사용1
		Random r = new Random();
		int num = r.nextInt();
		System.out.println(num);
		
		// 사용2 - static 메서드 
		int a = Math.abs(-34);
		System.out.println(a);
		System.out.println(Math.random()); // 0~1 사이 임의값
		
		String b = "123";
		int bb = Integer.parseInt(b);
		bb++;
		System.out.println(bb);
		
		
	}


}
