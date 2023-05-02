package servlet.model;
//O,O,O + O,O + ,,,,

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO {
	//공통적인 로직...
	Connection getConnection() throws SQLException ;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	//비지니스 로직...
	void registerMember(MemberVO vo) throws SQLException;
	ArrayList<MemberVO> showAllMember() throws SQLException;
	MemberVO findByIdMember(String id) throws SQLException;	
	
	/*
	 * 보는 순간 화면 구성이 떠올라야 한다.
	 * 이 DAO를 상속받아서 DAOImpl을 만든다.
	 */
	
	MemberVO login(String id, String pass) throws SQLException;	
}