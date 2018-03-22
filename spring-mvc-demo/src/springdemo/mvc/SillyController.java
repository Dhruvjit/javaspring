package springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	// showForm is also used in helloworld controller with same name
	// this example demonstrates that during conflict of request mapping,
	// one must assign high level mapping on the class e.g. high level mapping
	// on public class as shown in helloworld controller  
	
	@RequestMapping("/showForm")
	public String displayTheForm() {	
		return "silly";
	}
	
}
