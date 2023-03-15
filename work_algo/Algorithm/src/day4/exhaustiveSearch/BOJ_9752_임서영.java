package day4.exhaustiveSearch;

import java.io.*;
import java.util.*;

public class BOJ_9752_임서영 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, cnt;
	static String word, line;
	static String[] split;
	static char[] answer;
	static boolean[] checked;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("src/input.txt"));
		while ((line = br.readLine()) != null) {
			split = line.split(" ");
			word = split[0];
			T = Integer.parseInt(split[1]);

			cnt = 0;
			flag = false;
			answer = new char[word.length()];
			checked = new boolean[word.length()];

			sb.append(word).append(" ").append(T).append(" = ");
			if (!perm(0)) sb.append("No permutation");
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

	private static boolean perm(int len) {
		if (len == word.length()) {
			if (++cnt == T) {
				for (char a : answer)
					sb.append(a);
				return true;
			}
			return false;
		}
		
		for (int i = 0; i < word.length(); i++) {
			if (!checked[i]) {
				checked[i] = true;
				answer[len] = word.charAt(i);
				perm(len + 1);
				checked[i] = false;
			}
		}
		return false;
	}

}
