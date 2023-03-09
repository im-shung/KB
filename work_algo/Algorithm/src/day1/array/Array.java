package day1.array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		int[] A = {100, 200, 300, 400, 500};
		System.out.println(A[2]);
		A[3] = 999;
		System.out.println(Arrays.toString(A));
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		int[][] B = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(Arrays.deepToString(B));
		B[1][1] = 999;
		System.out.println(Arrays.deepToString(B));
	}

}
