package com.kb.cms;

public class VipCustomer extends Customer {
	String hobby;
	String carNumber;

	public VipCustomer() {
		super();
	}

	public VipCustomer(int num, String name, String address, String hobby, String carNumber) {
		super(num, name, address);
		this.hobby = hobby;
		this.carNumber = carNumber;
	}

	public VipCustomer(int num, String name, String address, String carNumber) {
		this(num, name, address, "", carNumber);

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VipCustomer [").append(super.toString()).append(", hobby=").append(hobby)
				.append(", carNumber=").append(carNumber).append("]");
		return builder.toString();
	}




	
}
