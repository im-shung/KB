package day3.sort;

import java.util.Arrays;

public class MegerSort {

	static int[] arr = {5, 2, 8, 6, 4, 7, 3, 1};
	static int[] temp = new int[arr.length];
	
	public static void main(String[] args) {
		mergetSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	// left부터 right까지 정렬
	private static void mergetSort(int left, int right) {
		if (left >= right) return;
		
		int center = (left + right) / 2;
		
		// Divide : center를 기준으로 왼쪽, 오른쪽 배열 정렬
		mergetSort(left, center);
		mergetSort(center + 1, right);
		
		// Conquer : 왼쪽, 오른쪽 배열을 하나의 배열로 병합
		// 임시 배열에 복사
		for (int i = left; i <= right; i++) {
			temp[i] = arr[i];
		}

		int curIdx = left;
		int leftIdx = left;
		int rightIdx = center + 1;
		
		while (leftIdx <= center && rightIdx <= right) {
			if (temp[leftIdx] < temp[rightIdx]) {
				arr[curIdx++] = temp[leftIdx++];
			} else {
				arr[curIdx++] = temp[rightIdx++];
			}
		}
		
		// 남아있는 값 처리
		while (leftIdx <= center) {
			arr[curIdx++] = temp[leftIdx++];
		}
		while (rightIdx <= right) {
			arr[curIdx++] = temp[rightIdx++];
		}
	}

}
