package kb1반_임서영2;

import java.io.*;
import java.util.*;

public class kb1반_알고리즘2번_임서영 {

	static class Node {

		int y;
		int x;
		int cnt; // 코로나 3일 계산
		int total; // 전파된 날들

		public Node(int y, int x, int cnt, int total) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.total = total;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [y=").append(y).append(", x=").append(x).append(", cnt=").append(cnt)
					.append(", total=").append(total).append("]");
			return builder.toString();
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static final int EMPTY = 0;
	static final int STUDENT = 1;

	static int N, M; // N과 M은 최대 100
	static int[][] map; // (1,1)부터 시작
	static boolean[][] visit;
	static Node first; // 처음 코로나 걸린 학생의 좌표
	static int ans1, ans2;

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
		st = new StringTokenizer(br.readLine());
		// 0일에 코로나 걸림
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		first = new Node(y, x, 0, 0);
	}

	private static void pro() {
		bfs();
	}

	private static void bfs() {
		Queue<Node> que = new LinkedList<>();
		que.add(first);
		visit[first.y][first.x] = true;

		// t 일
		while (!que.isEmpty()) {
			Node cur = que.poll();
			cur.cnt += 1;
//			System.out.println(cur);
//			System.out.println();

			// 연결된 곳인가?
			for (int d = 0; d < 4; d++) {
				int dy = cur.y + DIR[d][0];
				int dx = cur.x + DIR[d][1];
					
				// 갈 수 있는가?
				if (canNotGo(dy, dx))
					continue;
				if (map[dy][dx] == EMPTY)
					continue;
				if (visit[dy][dx])
					continue;
				visit[dy][dx] = true;
				que.add(new Node(dy, dx, 0, cur.total + 1));
			}

			// 3일이 지나지 않았으면 다시 que에 삽입한다.
			if (cur.cnt < 3) {
				que.add(cur);
			} else {
//				System.out.println("나감 " + cur);
				ans1 = Math.max(ans1, cur.total + 3);
			}

		}

		// 더 이상 코로나가 전파되지 않는다. 
		
		// 학생이면서 코로나에 안 걸렸으면 카운트
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (map[y][x] == 1 && visit[y][x] == false) ans2++;
			}
		}
	}

	// 맵 외부 좌표이면 false 리턴
	private static boolean canNotGo(int y, int x) {
		return (y < 1 || x < 1 || y > N || x > M);
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		/* 입력 */
		input();
		/* 처리 */
		pro();
		/* 출력 */
		System.out.println(ans1);
		System.out.println(ans2);
		br.close();
	}

}
