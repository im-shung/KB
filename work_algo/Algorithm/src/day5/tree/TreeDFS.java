package day5.tree;

import java.util.Arrays;
import java.util.Scanner;

public class TreeDFS {
	static char[] nodes;
	static int SIZE, lastIndex;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SIZE = sc.nextInt();
		lastIndex = SIZE;
		nodes = new char[SIZE + 1];

		for (int i = 0; i < SIZE; i++) {
			nodes[i + 1] = (char) ('A' + i);
		}

		System.out.println(Arrays.toString(nodes));
		DFSByPreOrder(1); 		// 전위 순회 : 루트 -> 왼쪽 -> 오른쪽
		System.out.println();
		DFSByInOrder(1); 		// 중위 순회 : 왼쪽 -> 루트 -> 오른쪽
		System.out.println();
		DFSByPostOrder(1); 		// 후위 순회: 왼쪽 -> 오른쪽 -> 루트
	}

	// 전위 순회
	private static void DFSByPreOrder(int currIndex) {
		System.out.print(nodes[currIndex]); 	// 노드 방문
		if (currIndex * 2 <= lastIndex)
			DFSByPreOrder(currIndex * 2); 		// 왼쪽 자식 노드 방문
		if (currIndex * 2 + 1 <= lastIndex)
			DFSByPreOrder(currIndex * 2 + 1); 	// 오른쪽 자식 노드 방문
	}

	// 중위 순회
	private static void DFSByInOrder(int currIndex) {
		if (currIndex * 2 <= lastIndex)
			DFSByInOrder(currIndex * 2); 		// 왼쪽 자식 노드 방문
		System.out.print(nodes[currIndex]); 	// 노드 방문
		if (currIndex * 2 + 1 <= lastIndex)
			DFSByInOrder(currIndex * 2 + 1); 	// 오른쪽 자식 노드 방문
	}

	// 후위 순회
	private static void DFSByPostOrder(int currIndex) {
		if (currIndex * 2 <= lastIndex)
			DFSByPostOrder(currIndex * 2); 		// 왼쪽 자식 노드 방문
		if (currIndex * 2 + 1 <= lastIndex)
			DFSByPostOrder(currIndex * 2 + 1); 	// 오른쪽 자식 노드 방문
		System.out.print(nodes[currIndex]); 	// 노드 방문
	}
}
