package az.developia.mylibrary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.mylibrary.model.AuthorityModel;
import az.developia.mylibrary.model.UserModel;
import az.developia.mylibrary.repository.AuthRepository;
import az.developia.mylibrary.repository.UserRepository;

@Controller
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthRepository authRepository;

	@GetMapping(path = "/new")
	public String registration(Model model) {
		UserModel um = new UserModel();
		model.addAttribute("user", um);

		return "signup";
	}

	@PostMapping(path = "/save")
	public String save(@Valid @ModelAttribute(name = "user") UserModel userModel) {

		String newPass = new BCryptPasswordEncoder().encode(userModel.getPassword());

		userModel.setPassword("{bcrypt}" + newPass);
		userModel.setEnabled(1);
		userRepository.save(userModel);

		AuthorityModel authM = new AuthorityModel();
		authM.setUsername(userModel.getUsername());
		authM.setAuthority("students:list");

		List<AuthorityModel> list = new ArrayList<AuthorityModel>();
		list.add(authM);

		authRepository.saveAll(list);

		return "redirect:/";
	}

}
