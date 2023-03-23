package day7.graph;

import java.io.*;
import java.util.*;

// Main
public class BOJ_5547 {

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [y=").append(y).append(", x=").append(x).append("]");
			return builder.toString();
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int[][] DY = {{0, 1, -1, 1, 0, 1},{-1, 0, -1, 1, -1, 0}};
	static int[] DX = {-1 ,-1, 0, 0, 1, 1};
	
	static final int ODD = 0; // 홀수
	static final int EVEN = 1; // 짝수 
	static final char EMPTY = '0'; // 빈 공간
	static final char BUILD = '1'; // 건물
  
	static int W, H;
	static char[][] map;
	static boolean[][] visit;
	static int ans;

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H + 2][W + 2];
		for (int i = 1; i <= H; i++) {
			String line = br.readLine().replaceAll(" ", "");
			for (int j = 1; j <= W; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
//		System.out.println(Arrays.deepToString(map));
	}

	private static void pro() {

	}

	private static void bfs() {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(1, 1));
		visit[1][1] = true;
		
		while (!que.isEmpty()) {
			Node cur = que.poll();
			
			int dy = cur.y, dx = cur.x;
			
			for (int d = 0; d < 6; d++) {
				// 짝수열 건물
				if (cur.y % 2 == 0) {
					dy += DY[EVEN][d];
				}
				// 홀수열 건물 
				else {
					dy += DY[ODD][d];
				}
				dx += DX[d];
				
				
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
		System.out.println();
		br.close();
	}
}
