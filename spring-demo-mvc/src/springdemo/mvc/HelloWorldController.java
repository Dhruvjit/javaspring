package springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

// parent request mapping
@RequestMapping("/hello")
public class HelloWorldController {
	
	// child reqeust mapping 1
	// need a controller method to show the initial HTML form //
	@RequestMapping("/showForm")
	public String showForm(){
		
		// this will be passed to helloworld-form.jsp name 
		return "helloworld-form";
	}
	
	// child reqeust mapping 2
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// child reqeust mapping 3
	// new controller method to read from data
	// add data to model	
	@RequestMapping("/processFormVersion3")
	
	//public String letsShoutDude(HttpServletRequest request, Model model){
	
	// in below code we made use of @requestparam annotation instead of normal http request
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model){
		
		// read the request parameter from the html form // we dont require below line when using @requestparam annotation
		//String theName = request.getParameter("studentName");
		
		//convert the data to all caps //
		theName = theName.toUpperCase();
		
		//create the message
		String result = "yo! yo! " + theName;
		
		//add message to model (adding spring data to model)
		// message is name and other argument, result is value
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
