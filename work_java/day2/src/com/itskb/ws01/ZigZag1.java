package com.itskb.ws01;

public class ZigZag1 {

	public static void main(String[] args) {
		int[][] intArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 18, 20 } };

		int row = intArray.length;
		int col = intArray[0].length;
		
		for (int r = 0; r < row; r++) {
			if (r % 2 == 0) {
				for (int c = 0; c < col; c++) {
					System.out.printf("%2d ", intArray[r][c]);
				}
			} else {
				for (int c = col - 1; c >= 0; c--) {
					System.out.printf("%2d ", intArray[r][c]);
				}
			}
			System.out.println();
		}

	} // end of main

} // end of class
