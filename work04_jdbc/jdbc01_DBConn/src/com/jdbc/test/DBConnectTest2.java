package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*

db연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩..
	Class.forName("드라이버명");
	
2. db연결

3. crud 작업

 */
public class DBConnectTest2 {

	public static void main(String[] args) {
		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // fcqn
			System.out.println("1. Driver Loading...Success...");
			
			// 2. db 연결...Connection반환
			// @param1 : url
			// @param2 : 계정
			// @param3 : 비번
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db", "1234");
			System.out.println("2. DB Connect...Success...");
			
			// 3. PreparedStatement 객체 생성...이때 인자값으로 쿼리문 입력(delete....333 삭제)
//			String query = "delete custom where id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("3. PreparedStatement 객체...생성...");
//			
//			ps.setInt(1, 333);
//			// 4. 쿼리문 실행
//			System.out.println("4. " + ps.executeUpdate() + " ROW DELETE !!!");
			
		
//			String query = "update custom set address = ? where id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, "뉴욕");
//			ps.setInt(2, 111);
//			
//			System.out.println(ps.executeUpdate() + "ROW UPDATE OK~~!!");
			
			
			String query = "SELECT id, name, address FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(); // select문 실행 --> 테이블의 데이터가 리턴된다.
			while (rs.next()) { // row 데이터가 있을 때까지 실행
				System.out.println(rs.getInt("id") + "\t"
								+ rs.getString("name") + "\t"
								+ rs.getString("address") + "\t");
			}
			
			/*
			 ㅡㅡㅡㅡㅡㅡㅡㅡ
			     BOE
			 ㅡㅡㅡㅡㅡㅡㅡㅡ
			 |111|길복순|뉴욕| next();
			 |222|복순길|서울| next();
			 |333|순길복|여수| next();
			 getInt|getString|getString
			 ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			 	  EOE
			 ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			
			
			 
			 */
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("1. Driver Loading...Fail..."); // driver 로딩 실패
		} catch (SQLException e) {
			System.out.println("2. DB Connect...Fail...");
		} 
	}

}
