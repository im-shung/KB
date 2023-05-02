package spring.service.dice;

/*
 * DiceA, DiceB, DiceC가 가지고 있는 핵심기능의 Template을 정의
 */
public interface Dice {
	int getValue();
	void setValue(int value);
	void selectedNumber();
}
