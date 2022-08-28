package Developia.spring.web.MVC.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Developia.spring.web.MVC.student.model.Book;
import Developia.spring.web.MVC.student.service.BookService;

@Controller
@RequestMapping(path = "/kitab")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping(path = "/list")
	public String showBookPage(Model model) {

		model.addAttribute("kitab", bookService.findThemAll()); // dirnaq arasina istenilen sey yazila biler ancaq o
																// onemlidir
		// cunki html-de dirnaq arasina yazdigimiz ad ile muraciet edirik

		return "books"; // books.html

	}

	@GetMapping(path = "/{id}")
	public String delete(@PathVariable Integer id) {
		bookService.deletedId(id);
		
		return "redirect:/kitab/list";
	}

	@GetMapping(path = "/search") // http://localhost:9090/search?s=(istenilen sey)
	public String search(@RequestParam(name = "s") String st, Model model2) {

		model2.addAttribute("kitab", null);

		return "books";
	}

	@GetMapping(path = "/new")
	public String registration(Model model3) {
		Book bk = new Book();
		model3.addAttribute("book", bk);

		return "save-book";
	}

	@PostMapping(path = "/save")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book, BindingResult br) {

		if (br.hasErrors()) {
			return "save-book";
		}

		bookService.save(book);

		return "redirect:/kitab/list";
	}
}
