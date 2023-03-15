package day4.exhaustiveSearch;

import java.util.*;

public class Permutation1 {

	static int N, R, totalCnt;
	static int[] numbers; // 선택한 숫자
	static boolean[] isSelected; // 카드 선택 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); 
		R = sc.nextInt(); 
		numbers = new int[R];
		isSelected = new boolean[N + 1];
		
		perm(0);
	}
	
	// 순열 := N개중 중복없이 M개를 순서있게 나열하기
	// cnt := 현재 뽑아야하는 카드의 위치
	// isSelected := 카드 중복 방지
	static void perm(int cnt) { 
		if (cnt == R) { // 기저(제일 끝에 있는) 조건
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			System.out.println(Arrays.toString(isSelected));
			return;
		}
		for (int card = 1; card <= N; card++) {
			if (isSelected[card]) continue;
			numbers[cnt] = card; // cnt번째 카드는 card 숫자 선택
			isSelected[card] = true;
			perm(cnt + 1);
			isSelected[card] = false;
		}
	}

}
// 4
// 3