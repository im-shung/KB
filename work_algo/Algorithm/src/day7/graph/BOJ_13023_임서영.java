package day7.graph;

import java.io.*;
import java.util.*;

public class BOJ_13023_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			if (ans == 1) {
				System.out.println(ans);
				return;
			}
			DFS(i, 1);

		}
		System.out.println(0);
	}

	private static void DFS(int curr, int cnt) {
		visited[curr] = true;
		if (cnt == 5) {
			ans = 1;
			return;
		}
		for (int node : adjList[curr]) {
			if (!visited[node]) {
				DFS(node, cnt + 1);
			}
		}
		visited[curr] = false;
	}
	 //끊기는 지점을 false로 바꿔서 다시 돌아올 수 있게 함.
}
