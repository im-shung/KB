import java.util.*;

/*
 * 점수를 입력받아 80점 이상이면 합격메시지를 그렇지 않으면 불합격 메시지를 출력하는 작업을 반복하다가 
 * 0~100점 이외의 점수가 입력되면 종료하는 프로그램을 작성하시오.
 * 출력 예
 	점수를 입력하세요. 50
	죄송합니다. 불합격입니다.
	점수를 입력하세요. 95
	축하합니다. 합격입니다.
	점수를 입력하세요. 101
 */

public class Main9041 {

	static Scanner sc = new Scanner(System.in);
	static int input;

	public static void main(String[] args) {

		while (true) {
			System.out.print("점수를 입력하세요. ");
			input = sc.nextInt();

			if (input < 0 || input > 100)
				break;
			
			if (input >= 80) {
				System.out.println("축하합니다. 합격입니다.");
			} else {
				System.out.println("죄송합니다. 불합격입니다.");
			}
		}

	}

}
