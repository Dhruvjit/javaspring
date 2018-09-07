/*
 * lecture 279: Implement CustomerDAO class that takes informatio from cutomer
 * 
 * Main Topic: Building Database Web App Spring MVC and Hibernate
 * 
 * Here we create CustomerDAO class which extracts information from customer controller and
 * 
 * fetches needed data from database. All the interaction with Databases is handled by
 * 
 * CustomerDAO
 * 
 * */

package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

import org.hibernate.Session;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	// need to inject the session factory
	/* this adds all the dependency from the xml bean id = Session factory
	 * 
	 * 	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
		<property name="dataSource" ref="myDataSource" />
		<property name="packagesToScan" value="com.luv2code.springdemo.entity" />
		<property name="hibernateProperties">
		   <props>
		      <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
		      <prop key="hibernate.show_sql">true</prop>
		   </props>
		</property>
   	 *	</bean>	 
	 * 
	 * */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	/*
	 * @Transactional is used to manage begin and end of the session 
	 * there is no need for session.begintransaction() and
	 * session.gettransaction().commit by making use of this annotation
	 * 
	 * we have commented @transactional here because its already implemented
	 * in CustomerService.java class
	 * */
	
	//@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customer = theQuery.getResultList();
		
		// return the results
		return customer;

	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer ... finally!
		currentSession.save(theCustomer);
		
		// 
		
	}

}
