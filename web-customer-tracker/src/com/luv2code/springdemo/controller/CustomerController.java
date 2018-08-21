/*
 * lecture 270: Test spring MVC Controller
 * 
 * Main Topic: Building Database Web App Spring MVC and Hibernate
 * 
 * Here we design Spring MVC Controller
 * 
 * */

package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		return "list-customers";
		
	}
}
