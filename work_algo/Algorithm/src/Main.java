import java.io.*;
import java.util.*;

class Student {

	int type;
	int num;

	public Student(int type, int num) {
		super();
		this.type = type;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Student [type=" + type + ", num=" + num + "]";
	}

}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N; // 스위치개수
	static int M; // 학생수
	static int[] S; // 스위치상태 체크용
	static Student[] stu;

	static void input() throws IOException {
		br = new BufferedReader(new FileReader("src/input.txt"));
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		stu = new Student[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			stu[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}

	public static void pro() {
		// 스위치 번호는 1~n
		// 스위치 상태 '0' : 꺼져있음
		// 스위치 상태 '1' : 켜져있음

		// 학생 m명을 뽑아 1 <= num <= n 인 자연수를 나눠줌
		// 학생은 스위치조작을 한다.

		// 남학생: 스위치번호가 num의 배수이면, 스위치상태를 바꾼다.
		// 여학생: 번호가 num인 스위치를 중심으로 "좌우가 대칭"인 가장 많은 스위치를 포함하는 구간을 찾아, 그 구간의 스위치상태를 바꾼다.

		/* 상태를 바꿀 스위치번호를 찾는다. */
		for (Student s : stu) {
			int num = s.num; // 학생이 받은 스위치번호
			if (s.type == 1) { // 남학생
				for (int i = 1; i <= N; i++) {
					// 배수인가??
					if (i % num == 0) {
						change(i);
					}
				}
			} else if (s.type == 2) { // 여학생

				/* 특정 스위치를 중심으로 "좌우가 대칭"인 가장 긴 구간을 찾는다. */
				change(num);
				int l = num - 1;
				int r = num + 1;
				while (true) {
					if (l < 1 || r > N)
						break;
					if (S[l] == S[r]) {
						change(l); change(r);
						l--;
						r++;
					}
				}
			}
		}
	}
	
	public static void change(int x) {
		S[x] = (S[x] == 0) ? 1 : 0;
	}

	public static void main(String[] args) throws IOException {
		/* 입력 */
		input();
		/* 처리 */
		pro();
		/* 출력 */
		int start = 1;
		while (true) {
			if (N <= 20) {
				for (int i = start; i < start + N; i++) {
					sb.append(S[i]).append(" ");
				}
				break;
			} else {
				for (int i = 1; i < start + 20; i++) {
					sb.append(S[i]).append(" ");
				}
				N -= 20;
			}
		}
		System.out.println(sb);
	}
}
