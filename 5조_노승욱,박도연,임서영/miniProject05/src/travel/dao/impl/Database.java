package travel.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import travel.dao.DatabaseTemplate;
import travel.exception.DuplicateSSNException;
import travel.exception.NotEnoughMoneyException;
import travel.exception.NotEnoughQuantityException;
import travel.exception.RecordNotFoundException;
import travel.vo.Customer;
import travel.vo.Flight;
import travel.vo.Ticket;

public class Database implements DatabaseTemplate {

	public Database(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공..");
	}

	///////////////////////////////////////////////////////////////////////////////

	//////////////// 공통적인 로직 ////////////////////////////////////////
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Server Connection......");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		if (rs != null)
			rs.close();
	}

	public ArrayList<Ticket> getTicket(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Ticket> list = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT id,cnt,ssn,flight_id FROM ticket WHERE ssn=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, ssn);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Ticket(rs.getInt("id"), rs.getInt("cnt"), rs.getString("ssn"), rs.getInt("flight_id")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	///////////////////////////////////////////////////////////////////////////////
	//// 회원가입////
	private boolean ssnExist(String ssn, Connection conn) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT SSN FROM customer WHERE ssn=?";
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
				System.out.println(ps.executeUpdate() + " 회원가입 완료:) ");
			} else {
				throw new DuplicateSSNException("이미 있는 회원이십니다. ");
			}
		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public void deleteCustomer(String ssn) throws RecordNotFoundException, SQLException {

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
			} else {
				throw new RecordNotFoundException("삭제대상의 회원님이 존재하지 않습니다.");
			}

		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public void updateCustomer(Customer cust) throws SQLException, RecordNotFoundException {

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
				ps.setString(4, cust.getSsn());

				row = ps.executeUpdate();
				System.out.println(row + "회원정보 수정완료!");
			} else {
				throw new RecordNotFoundException("사람이 존재하지 않습니다.");
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
				Customer cust = new Customer(rs.getString("ssn"), rs.getString("name"), rs.getInt("asset"));
				list.add(cust);
				cust.setTickets(getTicket(cust.getSsn()));
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public Customer getCustomer(String ssn) throws SQLException, RecordNotFoundException {
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
				customer = new Customer(ssn, rs.getString("name"), rs.getInt("asset"));
				customer.setTickets(getTicket(ssn));
			} else {
				throw new RecordNotFoundException("사람이 존재하지 않습니다.");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return customer;

	}
	///////////////////////////////////////////////////////////////////////////////

	// flight_id가 있는지 없는지 확인하는 기능
	public boolean isExist(int flightId, Connection conn) throws SQLException {
		String sql = "SELECT flight_id FROM flight WHERE flight_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, flightId);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	// 항공권
	@Override
	public Flight searchFlight(int flightId) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Flight flight = null;
		try {
			conn = getConnect();
			if (isExist(flightId, conn)) {// 추가하려는 ssn고객이 없다면
				String query = "SELECT flight_id, price, start_time, arrive_time, start_area, arrive_area, quantity FROM flight WHERE flight_id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, flightId);

				rs = ps.executeQuery();
				if (rs.next())
					flight = new Flight(rs.getInt("flight_id"), rs.getInt("price"), rs.getDate("start_time"),
							rs.getDate("arrive_time"), rs.getInt("start_area"), rs.getInt("arrive_area"),
							rs.getInt("quantity"));
			} else {
				throw new RecordNotFoundException("해당하는 정보를 찾을 수 없습니다.");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return flight;
	}

	@Override
	public ArrayList<Flight> searchFlight() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Flight> flightList = new ArrayList<>();

		try {
			conn = getConnect();

			String query = "SELECT flight_id, price, start_time, arrive_time, start_area, arrive_area, quantity FROM flight";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			System.out.println(rs.next() == true);
			while (rs.next()) {

				flightList.add(new Flight(rs.getInt("flight_id"), rs.getInt("price"), rs.getDate("start_time"),
						rs.getDate("arrive_time"), rs.getInt("start_area"), rs.getInt("arrive_area"),
						rs.getInt("quantity")));
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return flightList;
	}

	// 해당 flight의 price를 가져온다.
	// 내가 가지고 있는 자산보다 flight의 price의 값이 초과라면 못산다.

	@Override
	public void buyTicket(Ticket ticket) throws SQLException, NotEnoughMoneyException, NotEnoughQuantityException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnect();
			conn.setAutoCommit(false);

			// 이미 해당 flight를 이미 샀다면 또 사지 못한다. (update를 이용해서 수량 변경 가능)
			String query = "SELECT flight_id FROM ticket WHERE ssn = ?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ticket.getSsn());
			
			rs = ps.executeQuery();

			if (!rs.next()) {
				int price = 0;
				int asset = 0;
				// 항공권 가격 조회 합니다.
				query = "SELECT price FROM flight WHERE flight_id = ?";

				ps = conn.prepareStatement(query);
				ps.setInt(1, ticket.getFlightId());

				rs = ps.executeQuery();
				if (rs.next()) {
					price = rs.getInt("price");
				}

				// 항공권의 남아있는 좌석 수를 조회합니다.
				int restSeat = restSeat(ticket.getFlightId());
				
				// 고객 자산을 조회 합니다.
				query = "SELECT asset FROM customer WHERE ssn = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ticket.getSsn());

				rs = ps.executeQuery();

				if (rs.next()) {
					asset = rs.getInt("asset");
				}

				// 항공권 가격보다 보유 자산이 더 적으면 롤백한다.
				// 항공권의 남아있는 좌석 수보다 고객이 주문한 수량이 많으면 롤백한다. 
				// 아니면 commit
				if (asset >= price * ticket.getCnt()) {
					if (restSeat < ticket.getCnt()) {
						throw new NotEnoughQuantityException("해당 항공권의 잔여 좌석이 부족합니다.");
					}
					query = "INSERT INTO ticket(id,cnt,ssn,flight_id) VALUES(ticket_seq.nextVal,?,?,?)";
					ps = conn.prepareStatement(query);

					ps.setInt(1, ticket.getCnt());
					ps.setString(2, ticket.getSsn());
					ps.setInt(3, ticket.getFlightId());

					conn.commit();
					System.out.println(ps.executeUpdate() + "row INSERT OK!");
				}
				else {
					throw new NotEnoughMoneyException("해당 항공권의 가격보다 고객의 자산이 부족합니다.");
				}
			}

			else {
				System.out.println("이미 예약하신 항공권이 존재합니다.");
			}

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public void updateTicket(int cnt, String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "UPDATE ticket SET cnt=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cnt);
			ps.setString(2, ssn);

			int row = ps.executeUpdate();
			if (row == 1)
				System.out.println(row + " UPDATE TICKET OK...");
			else
				throw new RecordNotFoundException("수정할 티켓의 고객이 없습니다");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void cancelTicket(String ssn, int flightId) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "DELETE FROM ticket WHERE ssn = ? AND flight_id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setInt(2, flightId);

			int row = ps.executeUpdate();
			if (row == 1)
				System.out.println(row + " DELETE TICKET OK...");
			else
				throw new RecordNotFoundException("수정할 티켓의 고객이 없습니다");
		} finally {
			closeAll(ps, conn);
		}
	}

///////////////////////////////////////////////////////////////////////////////


	// 항공권별 판매된 좌석 수를 조회합니다. 
	@Override
	public int countSeat(int flightId) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnect();
			String query = "select flight_id, sum(cnt) from ticket group by flight_id having flight_id =?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, flightId);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("sum(cnt)");
			else
				throw new RecordNotFoundException("해당 항공권을 구매한 사람이 없습니다.");

		} finally {
			closeAll(ps, conn);
		}
	}

	// 항공권별 남은 좌석 수를 조회합니다. 
	public int restSeat(int flightId) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnect();
			String query = "select (QUANTITY- ?) rest from flight where flight_id = ?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, countSeat(flightId));
			ps.setInt(2, flightId);

			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("rest");
			else
				throw new RecordNotFoundException("해당 항공편이 없습니다.");

		} finally {
			closeAll(ps, conn);
		}
	}

}
