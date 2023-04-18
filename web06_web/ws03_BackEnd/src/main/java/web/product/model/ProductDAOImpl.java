package web.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO {
	private DataSource ds;
	private static ProductDAOImpl dao = new ProductDAOImpl();

	private ProductDAOImpl() {
		try {
			Context ic = new InitialContext();
			//DataSource Lookup
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource LookUp....Success");
		} catch (NamingException e) {
			System.out.println("DataSource LookUp....Fail");
		}
	}

	public static ProductDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// Connection Rent
		return ds.getConnection();
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
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	@Override
	public int AddPrdouct(Product vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		try {
			conn = getConnection();
			String query = "INSERT INTO product VALUES(product_seq.nextVal, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getDescription());
			System.out.println(ps.executeUpdate() + " ROW INSERT~~~OK~~!!");
			id = getCurrentId(ps, conn);
		} catch(SQLException e) {
			System.out.println(ps.executeUpdate() + " ROW INSERT~~~FAIL~~!!");
		} finally {
			closeAll(ps, conn);
		}

		return id;
	}

	@Override
	public int getCurrentId(PreparedStatement ps, Connection conn) throws SQLException {
		int id = 0;
		String query = "SELECT product_seq.CURRVAL FROM product";
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	        id = rs.getInt("CURRVAL");
	    }
		return id;
	}

	
	@Override
	public ArrayList<Product> findAllProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * from product";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(
						rs.getInt("prod_id"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("description")
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

}
