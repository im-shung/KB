import java.io.*;
import java.util.*;

/*
 * 정수를 계속 입력을 받다가 0이 입력되면 0을 제외하고 
 * 이전에 입력된 자료의 수와 합계, 평균을 출력하는 프로그램을 작성하시오. 
 * (평균은 반올림하여 소수 둘째자리까지 출력한다.)
 * 
 * 입력 예: 15 88 97 0
 * 출력 예: 
 	입력된 자료의 개수 = 3
	입력된 자료의 합계 = 200
	입력된 자료의 평균 = 66.67
 */

public class Main9042 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int input = 0;
		int sum = 0;
		int count = 0;
		while (true) {
			input = sc.nextInt();
			if (input == 0)
				break;
			count++;
			sum += input;
		}
		System.out.printf("입력된 자료의 개수 = %d\n", count);
		System.out.printf("입력된 자료의 합계 = %d\n", sum);
		System.out.printf("입력된 자료의 평균 = %.2f", (double) sum / count);
		

	}

}
