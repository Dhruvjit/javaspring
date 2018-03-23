package springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	
	
	// adding validation rules
	@Min(value=0, message = "must be greater than or equal to 0")
	@Max(value=10, message = "must be smaller than or equal to 10")
	private int freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalcode;
	

/////////////////////////////////////////////////////	
	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

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
