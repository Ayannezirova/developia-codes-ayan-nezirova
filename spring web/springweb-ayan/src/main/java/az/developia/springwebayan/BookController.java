package az.developia.springwebayan;

@Controller
public class BookController {

	@GetMapping
	public String getmapping() {

		return "books";

	}

}