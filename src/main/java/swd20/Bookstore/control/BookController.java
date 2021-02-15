package swd20.Bookstore.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@RequestMapping(value = "index")
	public String doWelcome() {
		
		return "welcome";
		
	}

}
