package day4.exhaustiveSearch;

import java.io.*;
import java.util.*;

public class BOJ_1339_임서영 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] arr;
	static int[] checked = new int[10];

	static void input() throws IOException {
		br = new BufferedReader(new FileReader("src/input.txt"));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		Arrays.fill(checked, -1);
		
		arr = new char[N][10];
		for(int num = 0; num < N; num++) {
			String word = br.readLine();
			int chat = 0;
			for (int idx = 10 - word.length(); idx < 10; idx++) {
				arr[num][idx] = word.charAt(chat++);
			}
		}
		
	}

	public static void pro() throws Exception {
		int val = 9;
		for (int idx = 0; idx < 10; idx++) {
			for (int num = 0; num < N; num++) {
				if (arr[num][idx] != '\u0000') {
					int i = arr[num][idx] - 'A';
					if (checked[i] == -1) {
						checked[i] = val--;
					}
				}
			}
		}
		
		int sum = 0;
		for (int num = 0; num < N; num++) {
			int subSum = 0;
			for (int idx = 0; idx < 10; idx++) {
				if (arr[num][idx] != '\u0000') {
					int i = arr[num][idx] - 'A';
					// 자리수 * 10 * val
//					System.out.printf("자리수 = %d, 값 = %f, ", (10 - idx) - 1, Math.pow(10, (10 - idx) - 1) );
					subSum += Math.pow(10, (10 - idx) - 1) * checked[i];
//					System.out.printf("subSum = %d\n", subSum);
				}
			}
			sum += subSum;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws Exception {
		/* 입력 */
		input();
		/* 처리 */
		pro();
		/* 출력 */
		br.close();
	}

}
