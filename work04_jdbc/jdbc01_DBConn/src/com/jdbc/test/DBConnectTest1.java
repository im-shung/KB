package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*

db연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩..
	Class.forName("드라이버명");
	
2. db연결

3. crud 작업

 */
public class DBConnectTest1 {

	public static void main(String[] args) {
		try {
			// 1. 
			Class.forName("oracle.jdbc.driver.OracleDriver"); //fqcn
			System.out.println("1. Driver Loading...Success.."); // driver 로딩 성공
			
			// 2. db 연결
			// param 1)디비서버주소 2)계정 3) 비번
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db", "1234");
			System.out.println("2. DB Connect...Success...");
			
			/*
			jdbc:oracle --> protocol
			@뒤에 127.0.0.1(localhost) --> IP 주소
			1521 --> 포트번호(벤더마다 달라짐)
			thin --> 연결방법
			
			DB연결을 위해 protocol쓴다.
			DB서버가 깔려있는 IP 주소
			 */
			
			// 3. crud 작업...db서버와 연결이 이뤄져야만 가능...
			// PreparedStatement 객체 생성
			String query = "INSERT INTO custom(id, name, address) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement...Creating...");
			
			// ?에 대한 값 바인딩
			ps.setInt(1, 444);
			ps.setString(2, "김한정");
			ps.setString(3, "사당동");
			
			System.out.println("=========INSERT=========");
			//진짜 쿼리문이 실행...excuteUpdate()
			System.out.println(ps.executeUpdate() + "row INSERT OK~~!!"); // return type이 int형...성공된 row수 리턴
			
			/*
			JDBC 작업 순서4단계 -- 순서 잘 기억하기
			1. Class.forName(fcqn);
			2. db 연결
				Connection conn = DriverManager.getConnection(서버주소, 계정, 비번);
			3. PreparedStatement 생성
				PreparedStatement ps = conn.prepareStatment(sql);
				쿼리문 값 바인딩 ps.setInt(1, 111);
			4. 쿼리문 수행
				ps.executeUpdate()
			*/
			
				
		} catch (ClassNotFoundException e) {
			System.out.println("1. Driver Loading...Fail..."); // driver 로딩 실패
		} catch (SQLException e) {
			System.out.println("2. DB Connect...Fail...");
		} 
	}

}
