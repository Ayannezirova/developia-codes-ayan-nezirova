package az.developia.springwebayann;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	List<Book> books = new ArrayList<Book>();
	{
		books.add(new Book(1, "Riyaziyyat", (double) 15));
		books.add(new Book(2, "Fizika", (double) 10));
		books.add(new Book(3, "Edebiyyat", (double) 25));
		books.add(new Book(4, "Umumi tarix", (double) 20));
		books.add(new Book(5, "Ingilis dili", (double) 30));
	}

	@GetMapping
	public String getmapping(Model m) {

		m.addAttribute("books", books);

		return "books";

	}

	@GetMapping(path = "/books/{id}")
	public String delete(@PathVariable Integer id) {
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
			}
		}

		return "redirect:/";
	}

	@GetMapping(path = "/search")
	public String search(@RequestParam(name = "b") String b, Model m) {
		List<Book> books = new ArrayList<Book>();
		for (Book bks : this.books) {
			if (bks.getName().contains(b)) {
				books.add(bks);
			}
		}
		m.addAttribute("books", books);

		return "books";

	}

	@GetMapping(path = "/books/new")
	public String registration(Model model) {
		Book bk = new Book();
		model.addAttribute("book", bk);
		return "save-book";

	}

	@PostMapping(path = "/save")
	public String saveBook(
			@ModelAttribute(name = "books") Book book) {
		books.add(book);
		return "redirect:/books/list";
	}
}