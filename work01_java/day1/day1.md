# day1

<aside>
⚠️ 프로그래밍? 데이터 와 처리

</aside>

Sysout  + ctrl + space : 출력문 단축키

encoding : 문자를 이진수로 변환

문자셋: Java는 유니코드로 이루어져 있고 아스키코드도 포함한다.

32bit 컴퓨터가 뜻하는 것은? 메모리에서 32bit씩 데이터를 가져온다.

---

## Data 형

### 정수형

- ~~byte - 1byte~~
- ~~short - 2byte~~
- **int - 4byte**
- log - 8byte

---

### 실수형

- float - 4byte
- **double - 8byte**
- **실수형이 어떻게 저장되는가?**
    
    소수점이 정규화를 거쳐서 저장이 된다. 
    
    정규화: 소수점이 첫번째 1을 만날 때 까지 이동 ? → 부동소수점
    
    실수형 연산을 컴퓨터에게 많이 시키면 느리다..~
    
    실수형 연산은 CPU가 아니라 GPU에게 많이 시킨다. GPU는 그래픽 처리하는 컴퓨터. CPU에게 시키면 부하가 많이 걸림
    
- **반복적인 실수형 계산하기**
    1. GPU를 사용한다.
    2. 정수형으로 계산 후 실수형으로 바꾼다.

---

### 문자형

- **char 형**
- 아스키코드 - 8bit
- 유니코드 - 16bit

### 논리형

- **boolean 형** - (true or false)

여러 개의 데이터 다루기: 배열, 클래스

---

## 연산자

이것만 기억하기 

```java
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
```

---

## Identifier

- 문법
    - 첫 글자 숫자 x
    - 공백 x
    - 예약어 x

---

## 제어문

```java
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
```