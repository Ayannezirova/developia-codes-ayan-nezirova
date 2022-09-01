package az.developia.springjpaayaan;

import java.util.List;

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

@Controller
@RequestMapping(path = "/kitab")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping(path = "/list")
	public String showBookPage(Model model) {

		model.addAttribute("kitab", bookRepository.findAll()); // dirnaq arasina istenilen sey yazila biler ancaq o
																// onemlidir
		// cunki html-de dirnaq arasina yazdigimiz ad ile muraciet edirik

		return "books"; // books.html

	}

	@GetMapping(path = "/{id}")
	public String delete(@PathVariable Integer id, Model model2) {
		if (bookRepository.findById(id).isPresent()) {
			bookRepository.deleteById(id);
		}else {
			model2.addAttribute("message", "bu id-li kitab tapilmadi, id = "+id);
			return "errorumuz";
		}

		return "redirect:/kitab/list";
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

		bookRepository.save(book);

		return "redirect:/kitab/list";
	}

	@GetMapping(path = "/search") // http://localhost:9090/search?s=(istenilen sey)
	public String search(@RequestParam(name = "s") String columnName, Model model2) {

		// List<Book> books = bookRepository.findAllByNameContainingOrPriceContaining(columnName,columnName);
		// List<Book> books = bookRepository.hamisiniTapinLimit(2, 2); // 2-ci məlumatdan sonra 2 dənə olan məlumatı göstərir.
		bookRepository.deleteByName(columnName);
		List<Book> books = bookRepository.findAll();

		model2.addAttribute("kitab", books);

		return "books";

	}
}
