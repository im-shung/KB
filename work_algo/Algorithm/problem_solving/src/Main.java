import java.io.*;
import java.util.*;

public class Main {

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
			return "Node [y=" + y + ", x=" + x + "]";
		}

		
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, money;
	static Node[] map = new Node[26];
	static int[] row = new int[6];
	static boolean[] rvisit = new boolean[6];
	static int[] col = new int[6];
	static boolean[] cvisit = new boolean[6];
	
	static void input() throws IOException {
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[val] = new Node(i, j);
			}
		}
	}

	public static void pro() throws IOException {
		int bingo = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int val = Integer.parseInt(st.nextToken());
				Node cur = map[val];
				
				// 수 check
				row[cur.y]++; col[cur.x]++;
				if (cur.y + cur.x == 4) left++;
				if (cur.y == cur.x) right++;
				
				// 빙고 check
				// 이미 방문했다면 계산하지 않는다.
				if (!rvisit[cur.y] && row[cur.y] == 5) {
					rvisit[cur.y] = true;
					bingo++;
				}
				if (!cvisit[cur.x] && col[cur.x] == 5) {
					cvisit[cur.x] = true;
					bingo++;
				}
				if (left == 5) {
					left = 0;
					bingo++;
				}
				if (right == 5) {
					right = 0;
					bingo++;
				}
				
				if (bingo == 3) {
					System.out.println(i * 5 + j + 1);
					return;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("src/input.txt"));
		/* 입력 */
		input();
		/* 처리 */
		pro();
		/* 출력 */
		System.out.println();
	}
}
