package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*

db연결 프로그램에 서버정보에 관련된 실제값이 하드코딩 되어있다.
드라이버 FCQN
서버 주소, 계정 이름, 비번
|
|
Meta Data 화(파일(xml, properties)로 분리) --> 모듈화 --> MyBatis 프레임워크
프로그램과 메타정보를 분리시키기
::
1. 드라이버로딩
2. db연결 ------------ Connection
3. PreparedStatement ------ PreparedStatement
4. 쿼리문 실행 		 ------ ResultSet
---------------------
5. 자원반환..close()
	열린 순서 반대로 닫는다.
	반드시 닫아야 한다...try-finally
	ResultSet
	
 */
public class DBConnectTest3 {

	public DBConnectTest3() throws ClassNotFoundException, SQLException {
		// 선언이 왜 바깥에 있어야하는지...
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			Class.forName(ServerInfo.DRIVER_NAME); 
			System.out.println("1. Driver Loading...Success...");
			
			
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("2. DB Connect...Success...");		
			
			String query = "SELECT id, name, address FROM custom";
			ps = conn.prepareStatement(query);
			
			
			// 4. 쿼리문 실행
			rs = ps.executeQuery(); 
			System.out.println("3. PreparedStatement...Query...Success...");		
			while (rs.next()) { 
				System.out.println(rs.getInt("id") + "\t" 
						+ rs.getString("name") + "\t" 
						+ rs.getString("address") + "\t");
			} // while
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnectTest3 db = new DBConnectTest3();
	}

}
