package com.jdbc.test;

import com.jdbc.dao.MemberDAOImpl;

import config.ServerInfo;

public class MemberDAOImpleTest {

	public static void main(String[] args) {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
	}

	static {
		//드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 결과 >>> 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 결과 >>> 실패");
		}
	}
}
