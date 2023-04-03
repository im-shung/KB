package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

// 비지니스로직 :: db Access하는 로직...sql이 동작
public class CustomerDAO {

	public CustomerDAO() {

	}
	
	/////////////////// 공통적인 로직 /////////////////////
	// public -> private :: 코드의 명료함을 높여준다
	// 다른 동료들이 보았을 때 이건 service용도가 아니라, 다른 코드의 util같은 역할임을 알 수 있다.
	private Connection getConnect() throws SQLException {
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection...OK");
		
		return conn;
		
	}
	
	
	/// 오버로딩
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		closeAll(conn, ps);
		if (rs != null) rs.close();		
	}
	
	

	// dml, select SQL이 각각의 기능에서 작동하도록 비지니스로직을 정의
	
/////////////////// 비지니스로직 로직 /////////////////////

	// 매우매우 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// 이 함수(기능)가 완벽한 하나의 Service 호출(회원가입) ...Session
	// insert into
	public void addCustomer(String ssn, String name, String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "INSERT INTO customer(ssn,name,address) values(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, name);
			ps.setString(3, address);
			
			int row = ps.executeUpdate();
			System.out.println(row + " row INSERT ok...");	
		} finally {
			ps.close();
			conn.close();
		}
		
	}

	// delete
	public void removeCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "delete from customer where ssn = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			System.out.println(ps.executeUpdate() + " row DELETE ok...");
		} finally {
			closeAll(conn, ps);
		}
	}

	// update set
	// 수정 대상: 프라이머리키 제외한 컬럼들
	public void updateCustomer(String ssn, String name, String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "update customer set name=?, address=? where ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, ssn);
			int row = ps.executeUpdate();
			System.out.println(row +" row update ok...");
			
			
		} finally {
			closeAll(conn, ps);
		}
	}

	// select
	public void printAllCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "select ssn, name, address from customer";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
		} finally {
			closeAll(conn, ps, rs);
		}
	}

}
