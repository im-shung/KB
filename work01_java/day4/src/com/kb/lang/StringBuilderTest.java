package com.kb.lang;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("ABC");
		System.out.println("DEF");
		System.out.println(sb);
		System.out.println(sb.charAt(2));
		System.out.println(sb.length());
		sb.setLength(4);
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb);
		String result = sb.toString();
		

	}

}
