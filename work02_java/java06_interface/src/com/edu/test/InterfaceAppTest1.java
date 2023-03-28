package com.edu.test;

//원래 인터페이스는 public
//인터페이스 구성요소 :: 추상메소드 + static final 상수(필드가 없다.)
interface Flyer {
	int MAX_SPEED = 200; //public static final
	
	public abstract void fly();//완벽한 템플릿...구현부가 없다.
	void land(); //앞에 public abstract으로 지정된다.
	void take_off();
}

abstract //Flyer를 상속한 클래스는 반드시 추상메소드들을 전부다 구현...일종의 Overriding
class Bird implements Flyer {

	public abstract void fly();
	
	@Override
	public void land() {
		System.out.println("Bird... land...");
		
	}

	@Override
	public void take_off() {
		System.out.println("Bird... take_off...");
	}
	
	//Bird만의 기능
	public String layEggs() {
		return "알을 낳다";
	}
	
}

class SuperMan implements Flyer {

	@Override
	public void fly() {
		System.out.println("SuperMan... fly...");
	}

	@Override
	public void land() {
		System.out.println("SuperMan... land...");
		
	}

	@Override
	public void take_off() {
		System.out.println("SuperMan... take_off...");
	}
	
	//SuperMan만의 기능
	public String stopBullet() {
		return "망또로 총을 막다";
	}
	
}


public class InterfaceAppTest1 {

	public static void main(String[] args) {
//		Flyer f1 = new Flyer();
//		Flyer f1 = new Bird();
		Flyer f1 = new SuperMan(); //객체 생성시 타입으로 존재한다!!

	}

}
