package day4.exhaustiveSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Subset {

	static int N, totalCnt;
	static int[] arr;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		subset(0);
	}
	
	// cnt := 몇 번째 값을 뽑고 있는지
	private static void subset(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(isSelected));
			for(int i = 0; i < N; i++)
				if (isSelected[i]) System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		// cnt번째 값을 뽑은 경우
		isSelected[cnt] = true;
		subset(cnt + 1);
		
		// cnt번째 값을 안 뽑는 경우
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}
