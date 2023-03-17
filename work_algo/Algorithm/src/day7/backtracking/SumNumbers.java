package day7.backtracking;

import java.util.Arrays;

public class SumNumbers {

	static StringBuilder sb = new StringBuilder();
	
	static int N = 1000, M = 5, target = 150;
	static int[] arr = new int[N];
	static int[] select = new int[M];
	
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		backtracking(0, 0);
		System.out.println(sb);

	}

	// cnt := cnt번째 숫자 뽑기
	private static void backtracking(int cnt, int startIndex) {
		
		if (cnt == M) {
			int total = 0;
			for (int x : select) total += x;
			if (total == target) sb.append(Arrays.toString(select)).append("\n");
			return;
		}
		
		for (int i = startIndex; i < N; i++) {
			select[cnt] = arr[i];
			int total = 0;
			for (int j = 0; j <= cnt; j++) {
				total += select[j];
			}
			if (total <= target) backtracking(cnt + 1, i + 1);
		}
		
	}
	
	

}
