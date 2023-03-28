package com.kb.lang;

public class StringTest {

	public static void main(String[] args) {
		String s = new String("IT's your life");
		String s1 = new String("ABC");
		String s2 = "ABC";
		String s3 = s2 + s;
		String s4 = "ABE";
		char ch = 'A';
		String s5 = "    ABE          ";
		
		System.out.println(s5.trim());
		System.out.println(ch + 1);
		System.out.println(++ch);
		System.out.println(ch++);
		System.out.println(s2 + 10 +30);
		System.out.println(10 +30 + s2);
		System.out.println(s.substring(3,8));
		System.out.println(s.indexOf("your"));
		System.out.println(s2.compareTo(s4)); // -2
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s3);
		System.out.println(s3.length()); 
	}

}