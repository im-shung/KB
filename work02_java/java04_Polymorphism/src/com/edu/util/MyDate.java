package com.edu.util;

public class MyDate {

	private int year;
	private int month;
	private int day;
	
	// String + Non-String =⇒ String Converting
	public String getDate() {
		return year + "," + month + "," + day;
	}
	

	@Override
	public String toString() {
		return year + "," + month + "," + day;
	}


	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	
}
