package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import travel.exception.DuplicateSSNException;
import travel.exception.SSNNotFoundException;
import travel.vo.Customer;
import travel.vo.Flight;
import travel.vo.Ticket;

public interface TravelDAO {
	
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;

	//Customer CRUD
	void addCustomer(Customer cust) throws SQLException, DuplicateSSNException ; // CREATE
	void deleteCustomer(String ssn) throws SSNNotFoundException, SQLException; // DELETE
	void updateCustomer(Customer cust) throws SQLException, SSNNotFoundException; // UPDATE // 돈을 수정 !! 

	//overloading
	ArrayList<Customer> getCustomer() throws SQLException;//READ
	Customer getCustomer(String ssn) throws SQLException, SSNNotFoundException;//READ

	//Flight CRUD
	
	//overloading
	Flight searchFlight(String flight_id); //READ
	ArrayList<Flight> searchFlight(); //READ

	Ticket buyTicket(Ticket ticket);
	void updateTicket(int cnt, String ssn, int flightId);
	void cancelTicket(String ssn, int flightId);

//	ArrayList<GuestHouse> getGuestHouse();
//	void addReservation(Reservation reservation);
//	void updateReservation(int personnel, String ssn, String address);
//	void cancelReservation(String ssn, String address);
}
