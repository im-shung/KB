package day5.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1828_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] A;
	static int sum, cnt;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});
		System.out.println(Arrays.deepToString(A));
		pro();
		System.out.println(cnt);
	}
	
	private static void pro() {
		int end = A[0][1];
		++cnt;
		for (int i = 1; i < N; i++) {
			System.out.println("end = " + end);
			if (A[i][0] >= end) {
				end = A[i][1];
				++cnt;
			}
		}

	}

}
