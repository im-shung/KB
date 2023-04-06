package travel.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import travel.dao.TravelDAO;
import travel.dao.impl.TravelDAOImpl;
import travel.exception.DuplicateSSNException;
import travel.exception.SSNNotFoundException;
import travel.vo.Customer;
import travel.vo.Flight;
import travel.vo.Ticket;

public class TravelDAOImpl implements TravelDAO{
	
	private static TravelDAOImpl dao = new TravelDAOImpl();
	private TravelDAOImpl() {
		System.out.println("DAO Instance Creating....Using Singltone");
	}
	public static TravelDAOImpl getInstance() {
		return dao;
	}
	
	
	
////////////////공통적인 로직 ////////////////////////////////////////
@Override
public Connection getConnect() throws SQLException {
Connection conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
System.out.println("DB Server Connection......");
return conn;
}

@Override
public void closeAll( PreparedStatement ps, Connection conn) throws SQLException {
if(ps!=null) ps.close();
if(conn !=null) conn.close();

}

@Override
public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
if(rs!=null) rs.close();
closeAll(rs,ps,conn);	
}

////회원가입////
private boolean ssnExist(String ssn,  Connection conn) throws SQLException{
	
	PreparedStatement ps = null;
	ResultSet rs = null;
//	boolean flag = false;	
		
	String query ="SELECT SSN FROM customer WHERE ssn=?";
	ps = conn.prepareStatement(query);
	ps.setString(1, ssn);
	rs = ps.executeQuery();	
	
	return rs.next();
}

	@Override
	public void addCustomer(Customer cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if (!ssnExist(cust.getSsn(), conn)) { // 추가대상이 없다면
			String query = "INSERT INTO customer (ssn, name, asset) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getSsn());
			ps.setString(2, cust.getName());
			ps.setInt(3, cust.getAsset());
			System.out.println(ps.executeUpdate()+" 회원가입 완료:) ");
			}
			else {
				throw new DuplicateSSNException("이미 있는 회원이십니다. ");
			}
		}finally {
			closeAll(ps, conn);
		}		
		
	}
	
	@Override
	public void deleteCustomer(String ssn) throws SSNNotFoundException, SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if (ssnExist(ssn, conn)) { // 삭제대상이 있다면
				String query = "DELETE customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				int row = ps.executeUpdate();
				System.out.println(row + "회원탈퇴 완료.");
			}
			else {
				throw new SSNNotFoundException("삭제대상의 회원님이 존재하지 않습니다.");
			}
			
		}finally {
			closeAll(ps, conn);
		}
		
		
	}
	@Override
	public void updateCustomer(Customer cust) throws SQLException, SSNNotFoundException {

		Connection conn = null;
		PreparedStatement ps = null;
		int row = 0;
		try {
			conn = getConnect();

			if (ssnExist(cust.getSsn(), conn)) {
				String query = "UPDATE customer SET ssn=?, name=?, asset=? where ssn=?";
				ps = conn.prepareStatement(query);

				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setInt(3, cust.getAsset());

				row = ps.executeUpdate();
				System.out.println(row + "회원정보 수정완료!");
			} else {
				throw new SSNNotFoundException("사람이 존재하지 않습니다.");
			}

		} finally {
			closeAll(ps, conn);
		}
		return;
		
	}
	
	@Override
	public ArrayList<Customer> getCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<>();

		try {
			conn = getConnect();
			String query = "SELECT ssn, name, asset FROM customer";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Customer(rs.getString("ssn"), rs.getString("name"), rs.getInt("asset")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return list;
	}
	@Override
	public Customer getCustomer(String ssn) throws SQLException, SSNNotFoundException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		try {
			conn = getConnect();
			String query = "SELECT ssn, name, asset FROM customer where ssn=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, ssn);

			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getString("ssn"), rs.getString("name"), rs.getInt("asset"));
			} else {
				throw new SSNNotFoundException("사람이 존재하지 않습니다.");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return customer;

	}
	//---------------
	
	// 항공권
	@Override
	public Flight searchFlight(String flight_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Flight> searchFlight() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ticket buyTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateTicket(int cnt, String ssn, int flightId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cancelTicket(String ssn, int flightId) {
		// TODO Auto-generated method stub
		
	}
	
}
