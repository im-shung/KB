package day7.graph;

import java.util.*;

public class AdjMatrix {

	static int V, E; // 인접 행렬
	static boolean[] isVisited; // 방문 여부
	static int[][] adjMatrix; // 정점의 수, 간선의 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjMatrix = new int[V][V];
		isVisited = new boolean[V];
		
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = 1;
		}
		
		
		sc.close();
	}
	
	static void BFS(int start) {
		Queue<Integer> que = new LinkedList<>();
		
		// 시작 정점 En-queue
		que.offer(start);
		
		while (!que.isEmpty()) {
			// De-que
			int curr = que.poll();
			System.out.println(curr);
			
			// En-que : curr의 주변 정점 추가
			for (int i = 0; i < V; i++) {
				if (adjMatrix[curr][i] != 0 && !isVisited[i]) {
					que.add(i);
				}
			}
		}
	}

}
