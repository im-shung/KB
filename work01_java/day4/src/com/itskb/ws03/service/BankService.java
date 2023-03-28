package com.itskb.ws03.service;

import java.util.*;

import com.itskb.ws03.dto.AccountDto;
import com.itskb.ws03.dto.UserDto;

public class BankService {

	private List<AccountDto> accountList;
	private List<UserDto> userList;

	public BankService() {
		userList = new ArrayList<>();
		userList.add(new UserDto(1, "A", "a@email.com", "010-1111-1111", false));
		userList.add(new UserDto(2, "B", "b@email.com", "010-2222-2222", false));
		userList.add(new UserDto(3, "C", "c@email.com", "010-3333-3333", false));

		accountList = new ArrayList<>();
		accountList.add(new AccountDto(1, "313-313-313", 30_000, 1));
		accountList.add(new AccountDto(2, "432-324-645", 970_000, 1));
		accountList.add(new AccountDto(3, "345-432-989", 48_000, 2));
		accountList.add(new AccountDto(4, "657-987-456", 170_000, 2));
		accountList.add(new AccountDto(5, "357-987-578", 5_000, 3));
		accountList.add(new AccountDto(6, "467-867-645", 900_000, 4));
	}

	public ArrayList<AccountDto> getAccountList(int userSeq) {
		ArrayList<AccountDto> list = new ArrayList<>();
		for (AccountDto accountDto : accountList) {
			if (accountDto.getUserSeq() == userSeq) {
				list.add(accountDto);
			}
		}

		return list;
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
		List<AccountDto> result = bankService.getAccountList(1);
		for (AccountDto accountDto : result) {
			System.out.println(accountDto);
		}
		
		System.out.println(bankService.getUserDetail(1));
	}
}
