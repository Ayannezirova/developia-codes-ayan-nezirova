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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(path = "/books")
public class BookController {

	List<Book> books = new ArrayList<Book>();
	{
		books.add(new Book(1, "Qürur və qərəz", (double) 15));
		books.add(new Book(2, "Yad", (double) 10));
		books.add(new Book(3, "Yüz ilin tənhalığı", (double) 25));
		books.add(new Book(4, "Cəsur yeni dünya", (double) 20));
		books.add(new Book(5, "Korluq", (double) 30));
	}

	@GetMapping // (path = "/book/list")
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

		return "redirect:/book/list";
	}

	@GetMapping(path = "/books/search")
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

		List<String> language = new ArrayList<>();
		language.add("AZ");
		language.add("TR");
		language.add("RU");
		language.add("GB");
		language.add("US");
		model.addAttribute("language", language);

		List<String> authors = new ArrayList<>();
		authors.add("Ceyn Ostin");
		authors.add("Alber Kamyu");
		authors.add("Qabriel Markes");
		authors.add("Oldos Haksli ");
		authors.add("Qustav Flober");
		authors.add("Frans Kafka");
		authors.add("Heminquey");
		authors.add("Viktor Hüqo");
		model.addAttribute("authors", authors);
		return "save-book";
	}

	@PostMapping(path = "/books/save")
	public String saveBook(@ModelAttribute(name = "books") Book book) {
		book.setId(books.size() + 1);
		books.add(book);
		return "redirect:/book/list";
	}
}