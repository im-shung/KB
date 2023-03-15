package kb1반_임서영;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb1반_알고리즘2번_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M; // 숫자 개수
	static int[] arr; // 수열
	static int maxSum;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0, 0);
		System.out.println(maxSum);
	}

	// 수열에서 3개를 고른다.-> 조합
	// 1) 세 수의 합은 M을 넘을 수 없으며
	// 2) 세 수의 합은 가장 큰 수가 되는 숫자 합이다.

	// cnt := 배열의 cnt번째 값
	// startIdx
	private static void comb(int cnt, int startIdx, int sum) {
//		System.out.printf("comb(%d, %d, %d)\n", cnt, startIdx, sum);
		if (cnt == 3) {
			if (sum <= M)
				maxSum = Math.max(maxSum, sum);
			
			return;
		}

		for (int i = startIdx; i < N; i++) {
			comb(cnt + 1, i + 1, sum + arr[i]);
		}
	}

}
