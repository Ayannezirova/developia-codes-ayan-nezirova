package az.developia.exerciseregistration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.exerciseregistration.dao.UserDAO;
import az.developia.exerciseregistration.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;

	boolean userCreated = false;

	@GetMapping(path = "/show-login")
	public String showLoginPage(Model model) {
		if (userCreated) {
			model.addAttribute("userCreated", "");
			userCreated = false;
		}
		return "custom-login";
	}

	@GetMapping(path = "/create-account")
	public String showCreateAccountPage(Model model1) {
		User user = new User();
		model1.addAttribute("user", user);

		return "create-account";
	}

	@PostMapping(path = "/create-account-process")
	public String saveUser(@Valid @ModelAttribute(name = "user") User user, BindingResult result, Model model3) {
		if (result.hasErrors()) {
			return "create-account";
		}
		// System.out.println(user);
		boolean userExists = userDAO.createUser(user);
		if (userExists) {
			model3.addAttribute("userExists", "");
			return "create-account";
		}
		userCreated = true;
		return "redirect:/show-login";
	}
}
