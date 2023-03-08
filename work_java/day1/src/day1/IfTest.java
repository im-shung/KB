package day1;

public class IfTest {

	public static void main(String[] args) {
		int score = 77;
		// if 1
		if (score > 70) {
			// 조건이 만족할 때 수행할 문장
			System.out.println("~~~합격~~~");
		}
		// if 2
		if (score > 70) {
			System.out.println("~~~합격~~~");
		} else {
			System.out.println("~~~불합격~~~");
		}

		// if 3
		if (score > 90) {
			System.out.println("A학점");
		} else if (score > 80) {
			System.out.println("B학점");
		} else if (score > 70) {
			System.out.println("C학점");
		} else {
			System.out.println("F학점");
		}
		// switch (break를 만날 때까지 내려간다.)
		switch (score / 10) {
		case 10:
			System.out.println("A학점");
			break;
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("F학점");
		}
		/*
		 * if 와 switch 의 차이
		 * 1) if문은 범위 설정
		 * 2) ~~~랑 같으냐 할 때는 switch문이 더 빠르다.
		 */
		
		
		// 3항 연산
		int result = (score > 70) ? 100 : 0; // (조건) ? 참일경우 값: 거짓일경우 값
		System.out.println(result);

	} // end of main

} // end of class
