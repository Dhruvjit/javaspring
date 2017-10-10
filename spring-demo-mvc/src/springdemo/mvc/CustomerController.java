package springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// this shows the form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// name = customer, value = Customer(); 
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	// this processes the form to get rid of 404 error 
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
			
			if (theBindingResult.hasErrors()) {
				return "customer-form";
			}
			else {
				return "customer-confirmation";
			}
			
	}  //processForm ends here
	
}
