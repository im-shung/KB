package kb1반_임서영1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb1반_알고리즘1번_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader("src/input.txt"));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		selectionSort();
		printArr();
	}
	
	// 선택 정렬인데 내림차순
	private static void selectionSort() {
		for (int i = 0; i < N; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}
			swap(i, maxIdx);
		}
	}
	
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArr() {
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
