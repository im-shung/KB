package day2.stackQueue;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		System.out.println(stack.toString());
		int top = stack.pop();
		System.out.println("top -> " + top + ", stack.toString() -> " + stack.toString());
		System.out.println("stack.peek() -> " + stack.peek());
		while (!stack.isEmpty()) {
			System.out.println("stack.pop() -> " + stack.pop());
		}
	}

}
