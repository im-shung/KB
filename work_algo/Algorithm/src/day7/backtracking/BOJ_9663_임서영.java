package day7.backtracking;

import java.io.*;
import java.util.*;

/*
 * N^2 중 중복없이 N개를 순서 있게 나열하기 
 */

public class BOJ_9663_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int INF;

	static int N;
	static int[] col;
	static int ans;

	public static void main(String[] args) throws Exception, IOException {

		N = Integer.parseInt(br.readLine());
		INF = N * N;
		col = new int[N];
		Arrays.fill(col, INF);
		backtracking(0, col);
		System.out.println(ans);
	}

	// y := 행
	// x := 열
	private static void backtracking(int y, int[] col) {
		if (y == N) {
			++ans;
			return;
		}

		for (int x = 0; x < N; x++) {
			if (canGo(y, x, col)) {
				// 체크인
				col[y] = x;
				// 간다.
				backtracking(y + 1, col);
				// 체크아웃
				col[y] = INF;
			}
		}
	}

	// (y,x) 좌표에 퀸을 놓을 수 있는지
	private static boolean canGo(int y, int x, int[] col) {
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			if (y != i) {
				if (col[i] == x || (i - col[i] == y - x) || (i + col[i] == y + x)) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

}
