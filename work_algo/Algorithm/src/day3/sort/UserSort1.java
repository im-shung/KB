package day3.sort;

import java.util.*;

class Person implements Comparable<Person>{
	int age, money;

	public Person(int age, int money) {
		super();
		this.age = age;
		this.money = money;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [age=").append(age).append(", money=").append(money).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Person o) {
//		if (this.money > o.money) return 1;
//		else if (this.money < o.money) return -1;
//		else return 0;
//		if (this.money != o.money)
//			return this.money - o.money;
//		else return this.age - o.age;
		return this.money != o.money ? this.money - o.money : this.age - o.age; 
	}

}

public class UserSort1 {

	
	public static void main(String[] args) {
		ArrayList<Person> arr = new ArrayList<>();
		arr.add(new Person(25, 100));
		arr.add(new Person(20, 500));
		arr.add(new Person(23, 400));
		arr.add(new Person(21, 400));
		System.out.println(arr);
		Collections.sort(arr);
		System.out.println(arr);
		
		
	}

}
