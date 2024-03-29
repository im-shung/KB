package com.kb.arr;

import java.util.Arrays;
import java.util.Random;

public class Test2 {
	static int[] su;

	public static void init() {
		su = new int[10];
		Random r = new Random();
		for (int i = 0; i < su.length; i++) {
			su[i] = r.nextInt(100);
		}
		System.out.println(Arrays.toString(su));
	}

	public static void main(String[] args) {
		init();

		// 총점을 구해보자
		System.out.println("총점: " + getSum());
		// 평균을 구해보자
		System.out.println("평균: " + getAverage());
		// 최대값을 구해보자
		System.out.println("최대값: " + getMax());
		// 편차가 가장 큰 값의 위치와 값을 구해보자
		std();
		
	
	}

	public static int getSum() {
		int sum = 0;
		for (int i = 0; i < su.length; i++) {
			sum += su[i];
		}
		return sum;
	}

	public static double getAverage() {
		return (double) getSum() / su.length;
	}

	public static int getMax() {
		int max = su[0];
		for (int i = 1; i < su.length; i++) {
			if (max < su[i])
				max = su[i];
		}
		return max;
	}
	
	// 절대값: Math.abs(값 또는 식)
	// 반올림: Math.round(값 또는 식) --> Math.round(값 * 100) / 100.0
	public static void std() {
		double diff = 0;
		int idx = -1;
		int val = 0;
		double avg = getAverage();
		for (int i = 0; i < su.length; i++) {
			if (diff < Math.abs(avg - su[i])) {
				diff = Math.abs(avg - su[i]);
				idx = i;
				val = su[i];
			}
		}
		System.out.printf("가장 편차가 심한 값은 %d, 위치는 %d이다.\n", val, idx);
	}
}
