package kb1반_임서영;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb1반_알고리즘3번_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final int SIZE = 19;
	static final int B = 1;
	static final int W = 2;
	static final int E = 0;
	
	// 8 방향
	static int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
	
	static int[][] map = new int[SIZE][SIZE];
	static boolean[][] visit = new boolean[SIZE][SIZE];
	static int winner;
	
	static int cnt;
	static int[] answer = new int[2];
	static boolean winFlag;
	
	public static void main(String[] args)  throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		/* 입력 */
		for (int y = 0; y < SIZE; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < SIZE; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
		
		/* 출력 */
		if (winFlag) {
			sb.append(winner).append("\n")
			.append(++answer[0]).append(" ").append(++answer[1]);
			System.out.println(sb);
		}
		else 
			System.out.println(0);

	}
	
	public static void pro() {
		/* 처리 */
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				// 시작점은 1 또는 2
				if (map[y][x] != E) {
					for (int i = 0; i < 8; i++) {
						if (winFlag || visit[y][x]) continue;
						int[] dir = D[i];
						int dy = y + dir[0];
						int dx = x + dir[1];

						// 갈 수 있는가?
						if (cannotGo(dy, dx) || map[dy][dx] != map[y][x]) continue; 

						// 간다.
						
						answer[0] = y;
						answer[1] = x;
						
						// 			칸 value, 행, 열, 방향, 카운트
						recursive(map[y][x], dy, dx, dir, 1);
						
					}
					
				}
					
			}
		}

	}

	private static void recursive(int mapVal, int y, int x, int[] dir, int cnt) {
		
		// end 조건
		if (cannotGo(y, x)) return;
		if (map[y][x] != mapVal) {
			if (cnt == 5) {
				winner = mapVal;
				winFlag = true;
				visit[y][x] = true;
			} else if (cnt > 5) {
				int t = cnt;
				int ty = y;
				int tx = x;
				while(t > 0) {
					int dy = ty - dir[0];
					int dx = tx - dir[1];
					visit[dy][dx] = true;
					t -= 1;
					ty = dy;
					tx = dx;
				}
				
				winner = E;
				winFlag = false;
			}
			return;
		} 
		
		int dy = y + dir[0];
		int dx = x + dir[1];
		answer[0] = Math.min(answer[0], dy);
		answer[1] = Math.min(answer[1], dx);
		recursive(mapVal, dy, dx, dir, cnt + 1);
		
	}

	private static boolean cannotGo(int y, int x) {
		return (y < 0 || x < 0 || y >= SIZE || x >= SIZE);
	}

	
}
