package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// dependency injection: need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	/* here we use transactional because now our service
	 * layer is going to define the begining and the end
	 * of the transaction
	 * 
	 *  since we have used @Transactional here, we can remove it
	 *  from the CustomerDAOImpl.java as begin and end of transaction
	 *  will be handled by this class. 
	 * */
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}
	
	
	
}
