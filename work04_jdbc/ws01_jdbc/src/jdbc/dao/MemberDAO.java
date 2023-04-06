package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dto.Member;
import jdbc.exception.RecordNotFoundException;

public interface MemberDAO {

	//public abstract
	//오버로딩
	
	// 공통적인 기능
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;
	
	// Business Logic Template
	void insertMember(Member member) throws SQLException;
	void deleteMember(int id) throws SQLException, RecordNotFoundException;
	int updateMember(Member member) throws SQLException, RecordNotFoundException;
	
	Member getMember(int id) throws SQLException, RecordNotFoundException;
	ArrayList<Member> getMember() throws SQLException;
	ArrayList<Member> getMember(String name) throws SQLException, RecordNotFoundException;
	
}
