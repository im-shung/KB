package com.kb.cms;

public class Car {

	String num;
	int price;

	// Overloading
	public void drive() {
		System.out.println("시속 60km로 달립니다.");
	}

	public void drive(int speed) {
		System.out.println("시속 " + speed + "km로 달립니다.");
	}

}
