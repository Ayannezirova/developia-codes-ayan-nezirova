package az.developia.springsecurityayaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springsecurityayaan.model.AuthorityModel;
import az.developia.springsecurityayaan.model.UserModel;
import az.developia.springsecurityayaan.repository.AuthorityRepository;
import az.developia.springsecurityayaan.repository.UserRepository;

@Controller
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	AuthorityRepository authRepo;

	@GetMapping(path = "/new")
	public String registration(Model model) {
		UserModel usM = new UserModel();
		model.addAttribute("user", usM);

		return "signup";
	}

	@PostMapping(path = "/save")
	public String save(@ModelAttribute(name = "user") UserModel user) {

		user.setPassword("{noop}"+user.getPassword());
		user.setEnabled(1);
		userRepo.save(user);
		
		AuthorityModel authM=new AuthorityModel();
		authM.setUsername(user.getUsername());
		authM.setAuthority("book:list");
		authRepo.save(authM);

		return "redirect:/";
	}

}
