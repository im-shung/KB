package com.edu.exception.test;
import java.io.FileNotFoundException;
/*
CompileException
1. 컴파일 X :: 컴파일러가 인식
2. 반드시 명시적으로 예외처리해서 사용해야하는 일종의 문법구조
 */
import java.io.FileReader;
import java.io.IOException;

class FileReading {
	public void readFile(String fileName) throws FileNotFoundException, IOException  {
		FileReader reader = null;
		try {
			reader = new FileReader(fileName); //CompileException
			System.out.println("1. 파일을 잘 찾았습니다.");
		} finally {
			reader.close();
		}
		System.out.println("2. FileReader API Creating...");
	}
}
public class CompileExceptionTest2 {

	public static void main(String[] args) throws Exception {
		//메모리에 올려야하니까 객체를 생성합니다.
		FileReading fr = new FileReading();
		//메모리에 올려놓고 함수에 접근합니다.
		fr.readFile("C:\\KB\\workshop_homework\\java_r_01\\java_r1_Workshop.pdf");
		//파일의 경로와 파일명을 어떻게 구분하는가?
		//파일명은 확장자가 있다.
		
		System.out.println("3. 파일을 잘 읽어들였습니다.");
	}

}
