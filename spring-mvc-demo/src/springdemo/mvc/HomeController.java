package springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// by this controller you tell spring that this is an mvc controller and make use of it
@Controller
public class HomeController {
	
	// this handles all sorts of web request like get-post
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
		
	}
	
}
