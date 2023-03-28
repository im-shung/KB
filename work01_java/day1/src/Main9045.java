import java.io.*;
import java.util.*;

/*
 * 아래 예와 같이 메시지를 출력하고 숫자를 입력받아 선택한 번호에 해당하는 메시지를 출력하는 작업을 반복하다가 
 * 4가 입력되면 메시지 출력 후 종료하는 프로그램을 작성하시오. 
 * (1~4 이외의 수가 입력되면 "잘못 선택하였습니다." 라고 출력한다.)
 * 
 * 입력 예: 
 * 출력 예: 
	1. 입력하기
	2. 출력하기
	3. 삭제하기
	4. 끝내기
	작업할 번호를 선택하세요. 2
	
	출력하기를 선택하였습니다.
	
	1. 입력하기
	2. 출력하기
	3. 삭제하기
	4. 끝내기
	작업할 번호를 선택하세요. 5
	
	잘못 선택하였습니다. 
	
	1. 입력하기
	2. 출력하기
	3. 삭제하기
	4. 끝내기
	작업할 번호를 선택하세요. 4
	
	끝내기를 선택하였습니다.
 */

public class Main9045 {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int input = 0;
		while (true) {
			sb.append("1. 입력하기\n").append("2. 출력하기\n").append("3. 삭제하기\n").append("4. 끝내기\n").append("작업할 번호를 선택하세요. ");
			System.out.println(sb);
			input = sc.nextInt();
			
			switch (input) {
			case 1:
				System.out.println("입력하기를 선택하였습니다.");
				break;
			case 2:
				System.out.println("출력하기를 선택하였습니다.");
				break;
			case 3:
				System.out.println("삭제하기를 선택하였습니다.");
				break;
			case 4:
				System.out.println("끝내기를 선택하였습니다.");
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
			}
			
		}


	}

}
