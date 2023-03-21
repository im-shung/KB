package day7.graph;

import java.io.*;
import java.util.*;

public class BOJ_1325_임서영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visit;
	static int[] count, outDegree;

	static int max;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		count = new int[N + 1];
		outDegree = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[B].add(A);
			if (A != B) {
				outDegree[B]++;
			}
		}
		
		System.out.println(Arrays.toString(adjList));
		
		for (int i = 1; i <= N; i++) {
			if (outDegree[i] == 0) {
				// 시작 정점 : outDegree가 0인 노드
				// 노드 i를 택할 때, 더 갈 수 없는 경우 outDegree가 0이다.
				DFS(i); 
			}
		}
		System.out.println(Arrays.toString(count));
	}

	// adjList[A] -> [B_1, B_2, .. ]
	// 정점 B를 택하면 정점 A를 택할 수 있다. 
	// 가장 많은 A를 택할 수 있는 B를 구하라
	private static void DFS(int in) {
		System.out.print(in);
		for (int out : adjList[in]) {
			count[out]++;
			outDegree[out]--;
			DFS(out);
		}
	}

}
