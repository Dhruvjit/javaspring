package springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this tells spring that this is a controller and make use of it
public class HomeController {
	
	/*
	 * we map some type of web request to below method (showPage) 
	 * by this annotation. Here "/" represents root, so if anyone goes to this website
	 * call will be given to this method here. This mapping would handle all kind of requests
	 * like GET, POST etc 
	 * *///
	@RequestMapping("/") // root
	
	// you can give any method name you want in below code
	public String showPage(){ 
		
		/*
		 * here spring will make use of config file and will find the view page /
		 *WEB-INF/view/main-menu.jsp /// view is "main-menu" 
		 * */ 
		return "main-menu";
	}
}
