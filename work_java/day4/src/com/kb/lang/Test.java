package com.kb.lang;

public class Test {

	public static void main(String[] args) {
		int i = 0;
		i = i + 3;
		
		int j = 0;
		System.out.println(i == j);
		
		
		int[] su = new int[3];
		System.out.println(su[1]);
		
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		String s3 = "ABC";
		String s4 = "ABC";
		
		
		System.out.println("s1 == s2 -> " + (s1 == s2));
		System.out.println("s1.equals(s2) -> " + s1.equals(s2));
		System.out.println("s3 == s4 -> " + (s3 == s4));
		System.out.println("s3.equals(s4) -> " + s3.equals(s4));
	}

}
