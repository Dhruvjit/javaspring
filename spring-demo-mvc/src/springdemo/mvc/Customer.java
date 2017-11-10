package springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Customer {
	
	// explanation for this to be covered later (why we put our error message in @Size)
	@NotNull(message="is required")
	// here 1 means minimum 1 character is required
	@Size(min=1,message="is required")
	private String firstName;
	
	// explanation for this to be covered later (why we put our error message in @Size)
	@NotNull(message="is required")
	
	// here 1 means minimum 1 character is required
	@Size(min=1,message="is required")	
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
