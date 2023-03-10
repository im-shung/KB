package day2.stackQueue;

import java.util.*;

public class LinkedListTest {

	public static void main(String[] args) {
		int N = 10_000;
		long start, end;
		ArrayList<Integer> arr = new ArrayList<>(); // 배열
		LinkedList<Integer> list = new LinkedList<>(); // 리스트
		
		
		// 리스트 값 삽입
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			list.add(0, i);
		}
		end = System.currentTimeMillis();
		System.out.println("반복문 실행 시간 : " + (end - start));
		
		// 배열 값 삽입
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			arr.add(0, i);
		}
		end = System.currentTimeMillis();
		System.out.println("반복문 실행 시간 : " + (end - start));
		
	}

}
