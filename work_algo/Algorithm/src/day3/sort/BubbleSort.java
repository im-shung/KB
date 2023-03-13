package day3.sort;

import java.util.Arrays;

public class BubbleSort {
	
	static int[] arr = {7, 2, 8, 1, 6, 3, 5};
	
	public static void main(String[] args) {
		bubbleSort();
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort() {
		// 코드 작성
		int n = arr.length;
		for (int i = 0; i <= n - 2; i++) {
			for (int j = 0; j <= n - i - 2; j++) {
				System.out.printf("i = %d, j = %d\n", i, j);
				if (arr[j] > arr[j + 1]) swap(j, j + 1);
			}
			System.out.println();
		}
		
	}
	
	private static void swap(int i, int j) { // i, j번째 인덱스의 값 교환
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
