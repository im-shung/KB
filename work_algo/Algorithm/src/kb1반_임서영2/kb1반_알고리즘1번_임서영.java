package kb1반_임서영2;

import java.io.*;
import java.util.*;

public class kb1반_알고리즘1번_임서영 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int V; // 마을 사람 수(V)
	static int E; // 관계의 수(E)

	static ArrayList<Integer>[] adjList; 
	static boolean[] visit; // 정점 방문여부
	static int ans;

	private static void input() throws IOException {
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		visit = new boolean[V + 1];
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
		}
//		System.out.println(Arrays.toString(adjList));
	}

	
	private static void pro() {
		dfs(1);
	}

	private static void dfs(int startNode) {
		for (int node : adjList[startNode]) {
			if (!visit[node]) {
				visit[node] = true;
				ans++;
				dfs(node);
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
