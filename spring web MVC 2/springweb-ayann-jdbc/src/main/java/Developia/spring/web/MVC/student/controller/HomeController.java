package Developia.spring.web.MVC.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path={"/home","/anaSehife",""})
	public String showHomePage() {
		return "home";
	}
}
