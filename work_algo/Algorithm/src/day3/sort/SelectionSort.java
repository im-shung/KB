package day3.sort;

import java.util.Arrays;

public class SelectionSort {

	// 배열
	static int[] arr = { 7, 2, 8, 1, 6, 3, 5 };

	public static void main(String[] args) {
		selectionSort();
		System.out.println(Arrays.toString(arr));
	}

	// 최소값을 맨 앞으로 이동, 그 다음 최소값을 두번째 위치로 이동 등을 반복하는 알고리즘
	public static void selectionSort() {
		// 1. 배열의 최소값을 찾아서 앞의 요소와 교환
		// 2. 맨 앞을 제외한 배열에서 위의 과정 수행

		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int minIndex = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
			}
			swap(i, minIndex);
		}

	}

//	public static void selectionSort() {
//		// 배열 크기
//		int N = arr.length;
//		
//		for (int i = 0; i < N; i++) {
//			int minIdx = i;
//			for (int j = i + 1; j < N; j++) {
//				if (arr[j] < arr[minIdx])
//					minIdx = j;
//			}
//			swap(minIdx, i);
//		}
//	}

	// i와 j 번째 값을 교환
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
