package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import travel.exception.DuplicateSSNException;
import travel.exception.NotEnoughMoneyException;
import travel.exception.NotEnoughQuantityException;
import travel.exception.RecordNotFoundException;
import travel.vo.Customer;
import travel.vo.Flight;
import travel.vo.FlightSeat;
import travel.vo.Ticket;

public interface DatabaseTemplate {
	
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;

	//Customer CRUD
	void addCustomer(Customer cust) throws SQLException, DuplicateSSNException; 
	void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException; 
	void updateCustomer(Customer cust) throws SQLException, RecordNotFoundException; 

	//overloading
	ArrayList<Customer> getCustomer() throws SQLException ;
	Customer getCustomer(String ssn) throws SQLException, RecordNotFoundException; 

	//Flight CRUD
	
	//overloading
	Flight searchFlight(int flightId) throws SQLException, RecordNotFoundException;
	ArrayList<Flight> searchFlight() throws SQLException; 

	void buyTicket(Ticket ticket) throws SQLException, NotEnoughMoneyException, NotEnoughQuantityException, RecordNotFoundException;
	void updateTicket(int cnt, String ssn) throws SQLException, RecordNotFoundException;
	void cancelTicket(String ssn, int flightId) throws SQLException, RecordNotFoundException;
	int countSeat(int flightId) throws SQLException, RecordNotFoundException;

}
