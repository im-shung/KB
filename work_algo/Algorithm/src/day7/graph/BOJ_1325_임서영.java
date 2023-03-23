package day7.graph;

import java.io.*;
import java.util.*;

public class BOJ_1325_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -0 } };
	static final int WALL = 1;
	static final int EMPTY = 0;

	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static int max = -1;
	static int[] cnt;

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		visit = new boolean[N + 1];
		cnt = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[b].add(a);
		}
	}

	private static void pro() {
		for (int startNode = 1; startNode <= N; startNode++) {
			visit = new boolean[N + 1];
			dfs(startNode, startNode);
			max = Math.max(max, cnt[startNode]);
			System.out.println();
		}
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == max) {
				sb.append(i).append(" ");
			}
		}
	}
	
	private static void dfs(int startNode, int node) {
		System.out.printf("dfs(%d, %d)\n",startNode, node);
		for (int adjNode : adj[node]) {
			System.out.println("adjNode = " + adjNode);
			System.out.println(Arrays.toString(visit));
			if (!visit[adjNode]) {
				visit[adjNode] = true;
				cnt[startNode]++;
				dfs(startNode, adjNode);
				visit[adjNode] = false;
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
		System.out.println(sb);
	}

}
