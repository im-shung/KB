import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2018 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, ans;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int s = 1, e = 1;
		int cnt = 0, sum = 0;
		
		while (e <= N) {
			System.out.println(sum);
			if (sum == N) {
				cnt++; sum -= s;
				s++;
			} else if (sum < N) {
				e++;
				sum += e;
			} else if (sum > N){
				sum -= s;
				s++;
			}
		}
		System.out.println(cnt);
	}
	
	/*
	 * dfs 로 풀기
	 */
	public static void pro1() {
		// 시작점
		for (int n = 1; n <= N; n++) {
			dfs(n, 0);
		}
		System.out.println(ans);
	}
	
	public static void dfs(int n, int sum) {
		if (sum >= N) {
			if (sum == N)
				ans++;
			return;
		}
		dfs(n + 1, sum + n);
	}
}
