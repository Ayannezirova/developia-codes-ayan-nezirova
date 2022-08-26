package Developia.spring.web.MVC.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

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

	List<Book> bks = new ArrayList<Book>();
	{
		bks.add(new Book(1, "Qürur və qərəz", 15));
		bks.add(new Book(2, "Yad", 10));
		bks.add(new Book(3, "Yüz ilin tənhalığı", 30));
		bks.add(new Book(4, "Cəsur yeni dünya", 20));
		bks.add(new Book(5, "Korluq", 25));
	}

	@GetMapping(path = "/list")
	public String showStundentPage(Model model) {

		model.addAttribute("kitab", bks); // dirnaq arasina istenilen sey yazila biler ancaq o onemlidir
											// cunki html-de dirnaq arasina yazdigimiz ad ile muraciet edirik

		return "books"; // books.html

	}

	@GetMapping(path = "/{id}")
	public String delete(@PathVariable Integer id) {
		Iterator<Book> iterator = bks.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
			}

		}
		return "redirect:/kitab/list";
	}

	@GetMapping(path = "/search") // http://localhost:9090/search?s=(istenilen sey)
	public String search(@RequestParam(name = "s") String st, Model model2) {
		List<Book> books = new ArrayList<Book>();
		for (Book b : this.bks) {
			if (b.getName().toLowerCase().contains(st.toLowerCase())) {
				books.add(b);

			}

		}
		model2.addAttribute("kitab", books);

		return "books";
	}

	@GetMapping(path = "/new")
	public String registration(Model model3) {
		Book bk = new Book();
		model3.addAttribute("book", bk);

		List<String> langs = new ArrayList<String>();
		langs.add("AZ");
		langs.add("TR");
		langs.add("RU");
		langs.add("GB");
		langs.add("US");
		model3.addAttribute("languages", langs);

		List<String> author = new ArrayList<String>();
		author.add("Ceyn Ostin");
		author.add("Alber Kamyu");
		author.add("Oldos Haksli");
		author.add("Qabriel Markes");
		author.add("Qustav Flober");
		author.add("Frans Kafka");
		author.add("Heminquey");
		author.add("Viktor Hüqo");
		model3.addAttribute("athrs", author);

		return "save-book";
	}

	@PostMapping(path = "/save")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book, BindingResult br) {

		if (br.hasErrors()) {
			return "save-book";
		}

		book.setPublishDate(LocalDate.now());
		book.setId(bks.size() + 1);
		bks.add(book);
		return "redirect:/kitab/list";
	}
}
