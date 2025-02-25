/*
 * lecture 270: Test spring MVC Controller
 * 
 * Main Topic: Building Database Web App Spring MVC and Hibernate
 * 
 * Here we design Spring MVC Controller
 * 
 * */

package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/* 
	
	inject the DAO into the controller so that it can communicate with customer DAO	
	
	here using Autowired, spring is going to scan the component that implements
	CustomerDAO interface. in our case it is located in CustomerDAOImpl class
	that has @Repository annotation on it
	
	@Autowired
	private CustomerDAO customerDAO;
	
	*/

	/* GetMapping is used to process all the `get` requests
	 * this is short form of using `@RequestMapping("/list", method=RequestMethod.GET)`
	 * */
	
	/* PostMapping is used to process all the `post` requests
	 * this is short form of using `@RequestMapping("/list", method=RequestMethod.POST)`
	 * postMapping fails here because here we don't have anything to post and below method
	 * doesn't support post mapping
	 * */
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		/* get the customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		*/
		
		// add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create the model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
}
