package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.controller.ControllerFactrory;


public class ClinetTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>>> Command 입력");
		
		String command = sc.next();
		ControllerFactrory factory = ControllerFactrory.getInstance();
		Controller controller = factory.createController(command);
		controller.handle(); // 자식 Controller가 동작한다.
		
		// 그림 그려보세요.

	}

}
