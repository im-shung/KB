import java.io.*;
import java.util.*;

/*
 * 정수를 계속 입력 받다가 0이 입력되면 
 * 입력된 수중 홀수의 합과 평균을 출력하는 프로그램을 작성하시오. (정수 미만은 버림)
 * 
 * 입력 예: 5 8 17 6 31 0
 * 출력 예: 
	홀수의 합 = 53
	홀수의 평균 = 17
 */

public class Main9043 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int input = 0;
		int sum = 0;
		int count = 0;
		while (true) {
			input = sc.nextInt();
			if (input == 0)
				break;
			if (input % 2 == 0)
				continue;
			count++;
			sum += input;
		}
		System.out.printf("홀수의 합 = %d\n", sum);
		System.out.printf("홀수의 평균 = %d", sum / count);
		

	}

}
