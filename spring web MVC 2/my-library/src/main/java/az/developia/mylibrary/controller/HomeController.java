package az.developia.mylibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path = { "/home", "/anaSehife", "" })
	// http://localhost:7077/home
	// http://localhost:7077/anaSehife
	// http://localhost:7077
	public String showHomePage() {
		return "home";
	}
}
