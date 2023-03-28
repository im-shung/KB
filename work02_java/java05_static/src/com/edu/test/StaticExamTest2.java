package com.edu.test;

class Car {
	int serialNumber;
	static int counter;
	
	Car() {
		counter++; //3
		serialNumber = counter; //3
	}
	
}
public class StaticExamTest2 {

	public static void main(String[] args) {

		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		System.out.println("=========field========");
		System.out.println(c1.serialNumber);//1
		System.out.println(c2.serialNumber);//2
		System.out.println(c3.serialNumber);//3
		
		
		System.out.println("\n=========static variable========");
		System.out.println(c1.counter);//3
		System.out.println(c2.counter);//3
		System.out.println(c3.counter);//3
		System.out.println(Car.counter);//3
		
	}

}
