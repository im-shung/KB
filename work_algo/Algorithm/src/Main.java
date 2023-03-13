import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int a, b, c, d, e, f;
	static int ans = 1_000_999;

	static void input() throws IOException {
		br = new BufferedReader(new FileReader("src/input.txt"));
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
	}

	public static void pro() throws Exception {
		long cf = c + f;
		long ad = a + d;
		long be = b + e;
		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if (cf == (ad * i + be * j))
				{
					System.out.println(i + " " + j);
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		/* 입력 */
		input();
		/* 처리 */
		pro();
		/* 출력 */
		System.out.println(ans == 1_000_999 ? 0 : ans);
		br.close();
	}
}
