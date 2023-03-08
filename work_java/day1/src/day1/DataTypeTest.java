package day1;

public class DataTypeTest {

	public static void main(String[] args) {
		int i = 300;
		// 4byte = 2^31 = 대략 21억
		
		long a = 30L; // 30l
		// 8byte
		
		/*
		 * 자동형변환
		 * 1) 큰 사이즈 <- 작은 사이즈
		 * 2) 실수 타입 <- 정수 타입
		 */
		
		a = i;
		// 8byte변수 a에 4byte변수 i의 값을 넣을 수 있다
		
		// float b= 3.4; 
		// 실수형의 기본형이 double이기에 에러난다.
		float b = 3.4f; 
		
		b = i; 
		// float형 변수 b에 int형 변수 i를 넣을 수 있다.
		
		b = a;
		// float형 변수 b에 long형 변수 a를 넣을 수 있다.
		
		/*
		 * 명시적형변환
		 * 1) 작은 사이즈 <- (type) 큰 사이즈
		 * 2) 정수 타입 <- (type) 실수 타입
		 */
		
		double d = 3.4;
		// i = d;
		i = (int) d;
		
		
		System.out.printf("i = %d, a = %d, b = %f, d = %f", i, a, b, d);

	}

}
