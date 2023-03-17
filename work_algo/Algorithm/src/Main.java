import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int y;
		int x;
		int cnt;

		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] primeNumbers = { 2, 3, 5, 7 };

	static int N;
	static int[] answer;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		/* 입력 */
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		visit = new boolean[N][4];
		/* 처리 */
		find(0);

		/* 출력 */
		System.out.println(sb);
	}

	private static void find(int cnt) {
		System.out.println(Arrays.deepToString(visit) + "\n");
		System.out.println("answer = " + Arrays.toString(answer));
		
		if (cnt == N) {
			int su = N - 1;
			int num = answer[N - 1];
			while (su-- >= 0) {
				num = (N-su) * 10 + num;
				System.out.println("su = " + su);
				if (!isPrimeNumber(num)) break;
			}
			if (su == 0) {
				for (int i = 0; i < N; i++)
					sb.append(answer[i]);
				sb.append("\n");
				
			}
			return; // 까먹지 말기!!!!! 
		}
		
		for (int i = 0; i < 4; i++) {
			if (!visit[cnt][i]) {
				visit[cnt][i] = true;
				answer[cnt] = primeNumbers[i];
				find(cnt + 1);
				visit[cnt][i] = false;
			}
		}
	}
	
	private static boolean isPrimeNumber(int x) {
		for (int n = 2; n < x; n++) {
			if (x % n == 0) return false;
		}
		return true;
	}

}
