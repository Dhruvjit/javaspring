package springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm(){
		
		// this will be passed to helloworld-form.jsp name
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read from data
	// add data to model	
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model){
		
		// read the request parameter from the html form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "yo! " + theName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
