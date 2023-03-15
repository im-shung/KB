package day4.exhaustiveSearch;

import java.util.*;

public class Combination {

	static int N, R, totalCnt;
	static int[] numbers, arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[N];
		arr = new int[R];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		comb(0, 0);
	}
	
	// 조합 := N개중 중복없이 M개 고르기
	// cnt := cnt번쨰 카드 뽑기
	// startIndex := arr에서 startIndex부터 카드 뽑기
	private static void comb(int cnt, int startIndex) {
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = startIndex; i < N; i++) {
			arr[cnt] = numbers[i]; // cnt번쨰 숫자를 배열의 i번째 숫자로 지정
			comb(cnt + 1, i + 1);
		}
		
	}
	
	

}
