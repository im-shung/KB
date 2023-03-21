package day9.unionfind;

import java.util.Arrays;

public class UnionFind {

	static int N = 7;
	static int[] parents = new int[N];
	
	// 크기가 1인 서로소 집합
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	// x 노드의 대표 노드 반환
	static int find(int x) {
		if (x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	// x U y
	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return;
		parents[yRoot] = xRoot;
	}
	
	// x와 y 노드가 같은 집합인지 확인
	static boolean isSame(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return true;
		return false;
		
	}
	
	public static void main(String[] args) {
		make();
		
		// {0} U {1}
		union(0, 1);
		System.out.println(Arrays.toString(parents));
		
		// {0. 1} U {2}
		union(1, 2);
		System.out.println(Arrays.toString(parents));
		
		// 0번 노드와 2번 노드가 같은 집합인지 확인
		System.out.println(isSame(0, 2));
	}

}
