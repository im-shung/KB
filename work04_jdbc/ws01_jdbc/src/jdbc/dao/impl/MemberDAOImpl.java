package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dao.MemberDAO;
import jdbc.dto.Member;
import jdbc.exception.RecordNotFoundException;
import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {

	// Singleton Pattern
	private static MemberDAOImpl dao = new MemberDAOImpl();

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("db 연결 결과 >>> 성공");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (conn != null)
			conn.close();
		if (ps != null)
			ps.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		closeAll(conn, ps);
		rs.close();
	}

	private boolean idExist(int ssn, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT id FROM Member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();

		return rs.next();
	}

	@Override
	public void insertMember(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO member(id, name, email, phone) VALUES(seq_id.nextVal,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPhone());
			System.out.println(ps.executeUpdate() + "row insert OK!");
		} finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void deleteMember(int id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();

			if (idExist(id, conn)) {
				String query = "DELETE member where id = ?";
				ps = conn.prepareStatement(query);

				ps.setInt(1, id);

				System.out.println(ps.executeUpdate() + "row delete OK!");
			} else {
				throw new RecordNotFoundException("사람이 존재하지 않습니다.");
			}

		} finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public int updateMember(Member member) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		int row = 0;
		try {
			conn = getConnect();

			if (idExist(member.getId(), conn)) {
				String query = "UPDATE member SET name=?, email=?, phone=? where id=?";
				ps = conn.prepareStatement(query);

				ps.setString(1, member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				ps.setInt(4, member.getId());

				row = ps.executeUpdate();
				System.out.println(row + "row update OK!");
			} else {
				throw new RecordNotFoundException("사람이 존재하지 않습니다.");
			}

		} finally {
			closeAll(conn, ps);
		}
		return row;
	}

	@Override
	public Member getMember(int id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member where id=?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				member = new Member(id, rs.getString("name"), rs.getString("email"), rs.getString("phone"));
			} else {
				throw new RecordNotFoundException("사람이 존재하지 않습니다.");
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return member;
	}

	@Override
	public ArrayList<Member> getMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();

		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone")));
			}
		} finally {
			closeAll(conn, ps, rs);
		}

		return list;
	}

	@Override
	public ArrayList<Member> getMember(String name) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();

		try {
			conn = getConnect();
			
			String query = "SELECT id, name, email, phone FROM member where name=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone")));
			}
		} finally {
			closeAll(conn, ps, rs);
		}

		return list;
	}

}
