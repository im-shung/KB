package com.jdbc.test;

import com.jdbc.dao.CustomerDAOImpl;
import com.jdbc.domain.Customer;

public class CustomerDAOImplTest {

	public static void main(String[] args) {

		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		try {
//			dao.registerCustomer(new Customer("111", "제임스", "보스톤"));
			dao.registerCustomer(new Customer("333", "제임스", "보스톤"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
