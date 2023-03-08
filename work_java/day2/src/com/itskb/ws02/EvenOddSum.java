package com.itskb.ws02;

import java.util.Scanner;

public class EvenOddSum {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		
		// 배열 초기화
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = sc.nextLine().split(" ");
			for (int j = 0; j <N; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		// 상 하 좌 우 값의 합이 짝수인 항목의 값을 구해보자.
		int[] DI = {1, -1, 0, 0};
		int[] DJ = {0, 0, 1, -1};
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int subSum = 0;
				for (int d = 0; d < 4; d++) {
					int di = i + DI[d];
					int dj = j + DJ[d];
					
					if (0 <= di && di < N && 0 <= dj && dj < N) {
						subSum += arr[di][dj];
					}
				}
				if (subSum % 2 == 0)
					sum += subSum;
			}
		}
		
		System.out.println(sum);

	}

}
