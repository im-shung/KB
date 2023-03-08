package com.itskb.ws01;

import java.util.Random;

public class RandomUtil {
	static Random random = new Random();

	public static int getRandomInt1(int from, int to) {
		// Math.random() // 0~1
		// Math.random() * (to -from) // to-from이 3이라면 0~2.9999
		return (int) Math.random() * (to - from + 1) + to;
	}

	public static int getRandomInt2(int from, int to) {
		// to 5 from 3
		// Random.nextInt(5 - 3 + 1) -> 0~2 
		// 0~2 + 3 -> 3~5
		return random.nextInt(to - from + 1)  + from;
	}
}
