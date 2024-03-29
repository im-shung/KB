package com.itskb.ws03.service;

import java.util.ArrayList;
import java.util.Arrays;

import com.itskb.ws03.dto.AccountDto;
import com.itskb.ws03.dto.UserDto;

public class BankService {
	private final int ACCOUNT_SIZE = 10;
	private final int USER_SIZE = 5;
	private final int ACCOUNT_CURRNT_SIZE = 6;
	private final int USER_CURRENT_SIZE = 3;

	private AccountDto[] accountList;
	private UserDto[] userList;

	public BankService() {
		userList = new UserDto[USER_CURRENT_SIZE];
		userList[0] = new UserDto(1, "A", "a@email.com", "010-1111-1111", false);
		userList[1] = new UserDto(2, "B", "b@email.com", "010-2222-2222", false);
		userList[2] = new UserDto(3, "C", "c@email.com", "010-3333-3333", false);

		accountList = new AccountDto[ACCOUNT_CURRNT_SIZE];
		accountList[0] = new AccountDto(1, "313-313-313", 30_000, 1);
		accountList[1] = new AccountDto(2, "432-324-645", 970_000, 1);
		accountList[2] = new AccountDto(3, "345-432-989", 48_000, 2);
		accountList[3] = new AccountDto(4, "657-987-456", 170_000, 2);
		accountList[4] = new AccountDto(5, "357-987-578", 5_000, 3);
		accountList[5] = new AccountDto(6, "467-867-645", 900_000, 4);

	}

	public AccountDto[] getAccountList(int userSeq) {
		ArrayList<AccountDto> list = new ArrayList<>();
		for (AccountDto accountDto : accountList) {
			if (accountDto.getUserSeq() == userSeq) {
				list.add(accountDto);
			}
		}

		return list.toArray(new AccountDto[list.size()]);
	}

	public UserDto getUserDetail(int userSeq) {
		for (UserDto userDto : userList) {
			if (userDto.getUserSeq() == userSeq) {
				return userDto;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BankService bankService = new BankService();
		System.out.println(Arrays.toString(bankService.getAccountList(1)) + "\n");
		System.out.println(bankService.getUserDetail(1));
	}
}
