package day4.exhaustiveSearch;

import java.util.*;

public class Permutation2 {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int N, R, ans;
	static int[] answer, input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		answer = new int[R];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) input[i] = sc.nextInt();
		
		perm(0);
		System.out.println(sb);
		System.out.println(ans);

	}

	private static void perm(int cnt) {
		if (cnt == R) {
			sb.append(Arrays.toString(answer)).append("\n");
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {		
				isSelected[i] = true;
				answer[cnt] = input[i];
				System.out.printf("isSelected[%d] = true, perm(%d)\n", i, cnt);
				perm(cnt + 1);
				isSelected[i] = false;
				System.out.printf("isSelected[%d] = false, perm(%d)\n", i, cnt);
			}
		}
	}

}
