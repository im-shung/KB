package com.kb.algo;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 1. 키보드 입력
//		Scanner sc = new Scanner(System.in);
		
		// 2. 파일 입력
		/*
		Scanner s = new Scanner(new File("input.txt")); // 프로젝트 폴더 아래 input.txt
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(a));
		*/

		// 3. 파일 입력
		/*
		System.setIn(new FileInputStream("input.txt"));
		Scanner s = new Scanner(System.in);
		int su = s.nextInt();
		int su2 = s.nextInt();
		System.out.println(su + " " + su2);
		*/
		
		// FileInputStream: file에서 8bit씩 읽어온다.
		FileInputStream fis = new FileInputStream("input.txt");
		// InputStreamReader: 8bit -> 16bit로 변경
		InputStreamReader isr = new InputStreamReader(fis); 
		// BufferedReader: 입출력 속도차를 위해서 버퍼를 제공
		BufferedReader br = new BufferedReader(isr); 
		String data = br.readLine();
		System.out.println(data);
		String[] d = data.split(" ");
		
		int[] sd = new int[d.length];
		for (int i = 0; i < d.length; i++) {
			sd[i] = Integer.parseInt(d[i]); // 정수 <- 문자열
		}
		System.out.println(Arrays.toString(sd));
	}
}
