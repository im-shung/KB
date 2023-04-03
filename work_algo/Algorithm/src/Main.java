import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static final int MAX = 51;
	
	static int N;
	static int[] A;
	static int[] D;
	static int cnt;
	
	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		D = new int[N + 1];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void pro() {
		for (int i = N; i > 1; i--) {
			int pointer = 1;
			int cnt = 100;
			while (i - pointer >= 1 && cnt > 0) {
				if ()
			}
		}
	}
	


	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		/* 입력 */
		input();
		/* 처리 */
		pro();
		/* 출력 */
		System.out.println(ans);
		br.close();
	}
}

