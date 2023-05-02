package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceAImpl implements Dice {

	// Field
	private int value;
	
	///Constructor
	public DiceAImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}
	
	public DiceAImpl(int value) {
		System.out.println("::"+getClass().getName()+" 생성자....");
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}

}
