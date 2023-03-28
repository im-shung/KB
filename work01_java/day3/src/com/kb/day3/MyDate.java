package com.kb.day3;

public class MyDate {
	int year;
	int month;
	int day;
	
	public String toString() {
		return year +"년 " + month + "월 " + day + "일";
	}
	
	public MyDate() {
		
	}
	
	public MyDate(int m , int d) {
		year = 2023;
		month = m;
		day = d;
	}
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
}
