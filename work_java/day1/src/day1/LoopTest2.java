package day1;

public class LoopTest2 {

	public static void main(String[] args) {
		// 1~100까지 짝수의 합을 구하기
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				sum += i;
		}
		System.out.println(sum);
		System.out.println(recursive(100, 0));

		// for문 횟수 줄이기 
		sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		// 1~100까지 3의 배수의 합을 구하기. 단, 3의 배수가 5의 배수가 될 때 종료한다.
		sum = 0;
		for (int i = 3; i <= 100; i += 3) {
			sum += i;
			if (i % 5 == 0)
				break;
		}
		System.out.println(sum);
		
		// 1~100까지 3의 배수의 합을 구하기. 단, 3의 배수가 5의 배수가 될 때 합계에서 제외한다.
		sum = 0;
		for (int i = 3; i <= 100; i += 3) {
			if (i % 5 == 0)
				continue;
			sum += i;
			
		}
		System.out.println(sum);
		// break 	-> for문과 switch문에 쓰인다.
		// continue -> for문에만 쓰인다.
		
	} // end of main

	static int recursive(int x, int sum) {
		if (x == 0)
			return sum;
		sum += x;
		return recursive(x - 2, sum);
	} 

} // end of class
