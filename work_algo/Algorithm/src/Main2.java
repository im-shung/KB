import java.io.*;
import java.util.*;

import java.util.*;

public class Main2 {

	static class Solution {
		static int[][] pirodoMemo;
		static int[] dogu;
		static Map<String, Integer> name;
		static boolean[] visit;
		static int n, m, answer;
		static String[] mineral;

		private void init() {
			// 피로도 표를 초기화합니다.
			pirodoMemo = new int[3][3];
			pirodoMemo[0] = new int[] { 1, 1, 1 };
			pirodoMemo[1] = new int[] { 5, 1, 1 };
			pirodoMemo[2] = new int[] { 25, 5, 1 };
			// new int[] 빼먹지 말기.

			System.out.println(Arrays.deepToString(pirodoMemo));

			// [광물이름,index] Map을 생성합니다.
			name = new HashMap<>();
			name.put("diamond", 0);
			name.put("iron", 1);
			name.put("stone", 2);
			System.out.println("name=" + name.get("diamond"));
		}

		public int solution(int[] picks, String[] minerals) {

			init();

			// static 변수를 쓰기 위함입니다.
			mineral = minerals;

			// 곡괭이의 수를 셉니다.
			n = Arrays.stream(picks).sum();
			// 곡괭이의 수만큼 int배열을 생성합니다.
			dogu = new int[n];
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < picks[i]; j++) {
					// 도구 배열에 순서대로 광물index를 삽입합니다.
					dogu[idx] = i;
				}
			}
			// 도구와 관련된 visit 배열 생성합니다.
			visit = new boolean[n];
			answer = Integer.MAX_VALUE;
			m = minerals.length;
			// 완전탐색을 실시합니다.
			dfs(0, 0);

			return answer;
		}

		private void dfs(int cnt, int pirodo) {
			System.out.println("cnt=" + cnt);
			// 모든 광물을 캤다면... 종료합니다.
			if (cnt * 5 >= m) {
				pirodo = Math.min(pirodo, answer);
				return;
			}

			// 0부터 n번째 도구
			for (int i = 0; i < n; i++) {
				// i번째 도구를 사용했는지 체크합니다.
				if (!visit[i]) {
					visit[i] = true;
					// 광물을 캐고 피로도를 측정
					// 도구 i를 사용했고,, 광물은 mineral
					// 현재 광물을 cnt만큼 사용했다...

					// i번째 도구로 광물 5개를 캡니다.
					for (int j = 0; j < 5; j++) {
						System.out.println("현재 " + (cnt * 5 + j) + "번째");
						if (cnt * 5 + j >= m) {
							pirodo = Math.min(pirodo, answer);
							return;
						}

						String mName = mineral[cnt * 5 + j];
						System.out.println(mineral[cnt * 5 + j]);
						System.out.println(name.get(mName) == null);
//						int val = name.get(mName);
						System.out.println("val" + name.get(mineral[cnt * 5 + j]));

						// pirodo += pirodoMemo[dogu[i]][name.get(mineral[cnt*5 + j])];
					}

					dfs(cnt + 1, pirodo);
					visit[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] picks = new int[] {1, 3, 2};
		String[] minerals = new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		s.solution(picks, minerals);

	}

}
