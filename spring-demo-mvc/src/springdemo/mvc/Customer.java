package springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Customer {
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 character/digits")
	private String postalCode;
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	////////////////
	
	@Min (value=0, message="must be equal to or greater than zero")
	@Max (value=10, message="must be less than equal to 10")
	private int freePasses;
	
	
	public int getFreePasses() {
		return freePasses;
	}
	
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	/////////////
	
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
