package com.kb.algo;

import java.util.Scanner;

public class Main9103 {

	static int sum = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fac(n);
		System.out.println(sum);
	}

	private static int fac(int n) {
		if (n == 0) return 0;
		sum *= n;
		return fac(n - 1);
	}
}
