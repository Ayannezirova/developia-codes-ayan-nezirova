package az.developia.springsecurityayaan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springsecurityayaan.model.Book;
import az.developia.springsecurityayaan.repository.BookRepository;

@Controller
@RequestMapping(path = "/kitab")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping(path = "/list")
	@PreAuthorize(value = "hasAuthority('book:list')")
	public String listt(Model model) {

		model.addAttribute("kitab", bookRepository.findAll()); // dirnaq arasina istenilen sey yazila biler ancaq o
																// onemlidir
		// cunki html-de dirnaq arasina yazdigimiz ad ile muraciet edirik

		return "books"; // books.html

	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('book:delete')")
	public String delete(@PathVariable Integer id, Model model2) {
		if (bookRepository.findById(id).isPresent()) {
			bookRepository.deleteById(id);
		} else {
			model2.addAttribute("message", "bu id-li kitab tapilmadi, id = " + id);
			return "errorumuz";
		}

		return "redirect:/kitab/list";
	}

	@GetMapping(path = "/new")
	@PreAuthorize(value = "hasAuthority('book:save')")
	public String registration(Model model3) {
		Book bk = new Book();
		model3.addAttribute("book", bk);

		return "save-book";
	}

	@PostMapping(path = "/save")
	@PreAuthorize(value = "hasAuthority('book:save')")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book, BindingResult br) {

		if (br.hasErrors()) {
			return "save-book";
		}

		bookRepository.save(book);

		return "redirect:/kitab/list";
	}

	@ExceptionHandler
	public String handleAccessDeniedException(AccessDeniedException exc, Model model4) {
		model4.addAttribute("message", "hüququn yoxdur");
		return "errorumuz";
	}
}
