package springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	private String firstname;
	
	@NotNull(message = "is required (coming from customer.java)")
	@Size(min = 1, message = "is required")
	
	// you can use a pattern to remove spaces, but it will failed to trim the spaces
	//@Pattern(regexp = "\\S+", message = "Spaces are not allowed")
	// best way is to use initbinder as shown in customercontroller.java
	private String lastname;
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
