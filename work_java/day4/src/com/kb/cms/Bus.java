package com.kb.cms;

public class Bus extends Car {

	int seat;

	public void autoDoor(boolean flag) {
		if (flag)
			System.out.println("Open Door");
		else
			System.out.println("Close Door");
	}
}
