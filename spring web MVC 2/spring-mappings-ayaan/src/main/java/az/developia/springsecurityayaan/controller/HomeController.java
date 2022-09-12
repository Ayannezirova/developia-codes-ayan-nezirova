package az.developia.springsecurityayaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path = { "/home", "/anaSehife", "" })
	// http://localhost:4404/home
	// http://localhost:4404/anaSehife
	// http://localhost:4404
	public String showHomePage() {
		return "home";
	}
}
