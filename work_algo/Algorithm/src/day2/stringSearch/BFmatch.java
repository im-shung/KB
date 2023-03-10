package day2.stringSearch;

import java.util.Scanner;

public class BFmatch {

	private static int bfMatch(String txt, String pat) {

		int T = 0; // txt 커서
		int P = 0; // pat 커서

		while (T != txt.length() && P != pat.length()) {
			if (txt.charAt(T) == pat.charAt(P)) { // 문자가 같다면, 모든 커서를 1증가 시킵니다.
				T++;
				P++;
			} else { // 문자가 같지 않다면, txt 커서는 [현재 위치 - 패턴 크기] + 1 로 이동합니다. pat 커서는 0으로 초기화됩니다.
				T = (T - P) + 1;
				P = 0;
			}
		}

		// T = txt.length() 또는 P = pat.length() 일 때 while문을 빠져나옵니다.

		if (P == pat.length()) // P = pat.length() -> 패턴과 일치하는 문자열이 있더라.
			return T - P;

		// T = txt.length() -> 문자열을 다 돌아봤는데 패턴이랑 일치하지 않더라.
		return -1;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("텍스트: "); 
		String s1 = sc.next();
		System.out.print("패 턴: ");
		String s2 = sc.next();
		// 문자열 s1에서 문자열 s2를 검색
		int idx = bfMatch(s1, s2);
		
		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		} else {
			// 일치하는 문자 바로 앞까지의 무자 개수를 반각 문자로 환산하여 구합니다.
			int len = 0;
			for (int i = 0; i < idx; i++) 
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트: " + s1);
			System.out.printf(String.format(" 패 턴 %%%ds\n", len), s2);
			
		}
	}
}
