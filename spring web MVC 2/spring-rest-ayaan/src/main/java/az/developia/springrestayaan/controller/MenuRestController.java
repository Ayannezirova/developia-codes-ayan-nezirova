package az.developia.springrestayaan.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrestayaan.repository.MenuRepository;

@RestController
@RequestMapping(path = "/menus")
@CrossOrigin(origins = "*")
public class MenuRestController {

	@Autowired
	MenuRepository menuRepository;

	@GetMapping
	public MyMenu m(@RequestHeader(name = "Accept-Language") Locale l) {

		String lang = l.getLanguage();
		MyMenu menu = menuRepository.findByLang(lang);

		return menu;
	}

}
