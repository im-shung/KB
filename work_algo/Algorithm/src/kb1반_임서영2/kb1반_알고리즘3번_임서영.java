package kb1반_임서영2;

import java.io.*;
import java.util.*;

public class kb1반_알고리즘3번_임서영 {

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static final int[][] DIR = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	static final char EMPTY = '.'; // 빈 칸

	static int R, C; // R = 10,000 , C = 500
	static char[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int ans;

	private static void printMap() {
		System.out.println("=========맵=========");
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(visit[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		printMap();
	}

	private static void pro() {
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
			printMap();
		}
	}

	private static void dfs(int y, int x) {
		if (x == C - 1) {
			flag = true;
			ans++;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int dy = y + DIR[d][0];
			int dx = x + DIR[d][1];
			if (canNotGo(dy, dx)) continue;
			if (visit[dy][dx]) continue;
			if (map[dy][dx] == EMPTY) {
				visit[dy][dx] = true;
				dfs(dy, dx);
				if (!flag)
					visit[dy][dx] = false;
			}
		}
	}

	// 맵 외부 좌표이면 false 리턴
	private static boolean canNotGo(int y, int x) {
		return (y < 0 || x < 0 || y >= R || x >= C);
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
