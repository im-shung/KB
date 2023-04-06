package broker.twotier.test;

import java.sql.SQLException;

import broker.twotier.dao.Database;
import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import config.ServerInfo;

public class DatabaseTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, DuplicateSSNException, RecordNotFoundException {

		Database db = new Database(ServerInfo.DRIVER_NAME);
//		System.out.println("========Insert=========");
//		db.addCustomer(new CustomerRec("999-999", "JDK", "Daegu"));
		
//		System.out.println("========Update=========");
//		db.updateCustomer(new CustomerRec("999-999", "JDK", "Seoul"));
		
//		System.out.println("========Delete=========");
//		db.deleteCustomer("999-999");
		
//		System.out.println("========Portfolio Select=========");
//		System.out.println(db.getPortfolio("999-999"));
		
//		System.out.println("========Customer Select=========");
//		System.out.println(db.getCustomer("111-111"));

//		System.out.println("========Customer All Select=========");
//		System.out.println(db.getAllCustomers());
		
		System.out.println("========Stock All Select=========");
		System.out.println(db.getAllStocks());
		
	}
	
}
