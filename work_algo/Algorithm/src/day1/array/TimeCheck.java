package day1.array;

public class TimeCheck {

	public static void main(String[] args) {
		int N = 10_000;
		long start, end;

		int total = 0;
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			total += i;
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
	}

}
