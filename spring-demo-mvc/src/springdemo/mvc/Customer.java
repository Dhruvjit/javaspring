package springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1)
	private String lastName;
	
	
	// getters and setters for first name
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	// getters and setters for last name
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
