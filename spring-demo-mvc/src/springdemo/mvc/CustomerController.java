package springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add an init binder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	
	// you can even use standard .trim() method here on string but
	// InitBinder is much more powerful and you can do lots of things with it
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	// this shows the form
	// it takes the model
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// name = customer, value = Customer(); 
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	// this processes the form to get rid of 404 error 
	@RequestMapping("/processForm")
	
	// tell spring to validate customer object that being passed in
	// use @valid to perform validation rules on customer object
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
			
			System.out.println("Last name: |" + theCustomer.getLastName() + "|");
			if (theBindingResult.hasErrors()) {
				return "customer-form";
			}
			else {
				return "customer-confirmation";
			}
			
	}  //processForm ends here
	
}
