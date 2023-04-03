package com.jdbc.test;

import java.sql.SQLException;

import com.jdbc.dao.CustomerDAO;

import config.ServerInfo;

/*

1. CustomerDAO객체 생성(==메모리에 올린다)
2. CustomerDAO의 기능을 호출

 */
public class CustomerDAOTest {

	public static void main(String[] args) throws SQLException {
		CustomerDAO dao = new CustomerDAO();
//		dao.addCustomer("222", "전도연", "당당동");
//		dao.removeCustomer("222");
//		dao.updateCustomer("222", "전도연", "방배동");
		dao.printAllCustomer();
		
	} // main
	
	// setting과 관련된 작업은 static block에서 초기화한다.
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver loading...Sucess...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading...Fail...");
		}
	}

}
