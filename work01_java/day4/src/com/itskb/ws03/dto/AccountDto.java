package com.itskb.ws03.dto;

public class AccountDto {

	private int accountSeq;
	private String accountNumber;
	private int balance;
	private int userSeq;

	public AccountDto() {

	}

	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
		this.accountSeq = accountSeq;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userSeq = userSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public String toString() {
		return "계좌 일련번호 : " + accountSeq + "\n번호 : " + accountNumber + "\n잔고 : " + balance + "\n고객 일련번호 : " + userSeq + "\n";
	}

}
