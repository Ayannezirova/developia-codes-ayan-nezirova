package az.developia.mylibrary.controller;

import java.util.Optional;

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

import az.developia.mylibrary.model.Book;
import az.developia.mylibrary.repository.BookRepository;

@Controller
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping(path = "/list")
	@PreAuthorize(value = "hasAuthority('books:list')")
	public String list(Model model) {

		model.addAttribute("books", bookRepository.findAll());
		return "books"; // books.html

	}

	@GetMapping(path = "/delete/{id}")
	@PreAuthorize(value = "hasAuthority('book:delete')")
	public String delete(@PathVariable Integer id, Model model2) {
		if (bookRepository.findById(id).isPresent()) {
			bookRepository.deleteById(id);
		} else {
			model2.addAttribute("message", "bu id-li kitab tapilmadi, id = " + id);
			return "errorumuz";
		}

		return "redirect:/books/list";
	}

	@GetMapping(path = "/edit/{id}")
	@PreAuthorize(value = "hasAuthority('book:edit')")
	public String edit(@PathVariable Integer id, Model model5) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		Book book = new Book();
		if (bookRepository.findById(id).isPresent()) {
			book = bookOptional.get();
		} else {

		}
		model5.addAttribute("book", book);

		return "save-book";
	}

	@GetMapping(path = "/new")
	@PreAuthorize(value = "hasAuthority('book:save')")
	public String registration(Model model3) {
		Book b = new Book();
		model3.addAttribute("book", b);

		return "save-book";
	}

	@PostMapping(path = "/save")
	@PreAuthorize(value = "hasAuthority('book:save')")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book, BindingResult br) {

		if (br.hasErrors()) {
			return "save-book";
		}

		bookRepository.save(book);

		return "redirect:/books/list";
	}

	@ExceptionHandler
	public String handleAccessDeniedException(AccessDeniedException exc, Model model4) {
		model4.addAttribute("message", "Sizin əməliyyat etməyinizə icazə yoxdur.");

		return "errorumuz";
	}

}
