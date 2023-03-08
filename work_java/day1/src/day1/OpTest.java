package day1;

public class OpTest {

	public static void main(String[] args) {
		int a = 100;
		int b = 3;
		// 산술연산자
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		System.out.println(a++);
		System.out.println(a);
		System.out.println(++b);
		// 비교연산자
		System.out.println(a > b);
		System.out.println(a <= b);
		// 논리연산자
		System.out.println("&& 와 ||");
		System.out.println(a > b && --a > 100); // 앞 조건이 true 경우 뒷 연산 수행
		System.out.println(a);
		System.out.println(a > b || --a > 100); // 앞 조건이 false 경우 뒷 연산 수행
		System.out.println(a);
		System.out.println("& 와 |");
		System.out.println(a > b & --a > 100); // 무조건 둘 다 수행한다.
		System.out.println(a);
		System.out.println(a > b | --a > 100); // 무조건 둘 다 수행한다.
		System.out.println(a);

	}

}
