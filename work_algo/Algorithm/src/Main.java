import java.io.*;
import java.util.*;

public class Main {

	static class Edge {
		int start;
		int from;

		public Edge(int start, int from) {
			super();
			this.start = start;
			this.from = from;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int N;
	static List<Edge> edgeList;
	static int ans;

	private static void input() throws IOException {

		N = Integer.parseInt(br.readLine());
		edgeList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			if (op == 1) {
				edgeList.add(new Edge(start, from));
			}
		}
	}

	private static void pro() {
		for (int )
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