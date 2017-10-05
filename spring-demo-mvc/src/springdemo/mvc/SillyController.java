package springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SillyController {

	// below line creates error because this request mapping is already used in another controller
	// will throw ambiguous mapping exception
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}
}
