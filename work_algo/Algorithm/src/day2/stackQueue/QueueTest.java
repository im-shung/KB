package day2.stackQueue;

import java.util.*;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(100);
		que.add(200);
		que.add(300);
		que.add(400);
		que.add(500);
		
		// 맨 앞 제거
		int front = que.poll();
		System.out.printf("front = %d, ", front);
		System.out.println("que = " + que.toString());
		
		// 맨 앞 출력
		System.out.println(que.peek());
		
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
		
		
	}

}
