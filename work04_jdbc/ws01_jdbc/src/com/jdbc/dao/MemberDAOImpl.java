package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dto.Member;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	
	// Singleton Pattern
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.DRIVER_NAME, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("db 연결 결과 >>> 성공");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (conn != null) conn.close();
		if (ps != null) ps.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		closeAll(conn, ps);
		rs.close();
	}

	@Override
	public void insertMember(Member member) {
	
	}

	@Override
	public void deleteMember(int id) {
		
	}

	@Override
	public int updateMember(Member member) {
		return 0;
	}

	@Override
	public Member getMember(int id) {
		return null;
	}

	@Override
	public ArrayList<Member> getMember() {
		return null;
	}

	@Override
	public ArrayList<Member> getMember(String id) {
		return null;
	}

}
