package day5.tree;

import java.util.Arrays;
import java.util.Scanner;

public class CompleteBinTree {

	static char[] nodes;
	static int SIZE, lastIndex;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SIZE = sc.nextInt();
		nodes = new char[SIZE + 1]; // 0번 인덱스 안 쓴다.
		lastIndex = SIZE; // 마지막 인덱스를 기억해야 한다.
		
		for (int i = 1; i <= SIZE; i++) {
			nodes[i] = (char) ('A' + (i - 1));
		}
		System.out.println(Arrays.toString(nodes));
		getChild(1);
		getParent(2);
	}

	private static void getChild(int currIndex) {
		int left = currIndex *  2;
		int right = currIndex *  2 + 1;
		if (left <= lastIndex) System.out.println(nodes[left]);
		if (right <= lastIndex) System.out.println(nodes[right]);
	}
	
	private static void getParent(int currIndex) {
		int parent = currIndex / 2;
		if (parent >= 1) System.out.println(nodes[parent]);
		
	}
}
