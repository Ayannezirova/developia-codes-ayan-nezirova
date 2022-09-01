package az.developia.springjpaayaan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path={"/home","/anaSehife",""})
	//http://localhost:8088/home
	//http://localhost:8088/anaSehife
	//http://localhost:8088
	public String showHomePage() {
		return "home";
	}
}
