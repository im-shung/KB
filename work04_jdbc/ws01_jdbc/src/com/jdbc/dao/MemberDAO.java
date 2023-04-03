package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dto.Member;

public interface MemberDAO {

	//public abstract
	//오버로딩
	
	// 공통적인 기능
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;
	
	// Business Logic Template
	void insertMember(Member member);
	void deleteMember(int id);
	int updateMember(Member member);
	Member getMember(int id);
	ArrayList<Member> getMember();
	ArrayList<Member> getMember(String id);
	
}
