package Developia.spring.web.MVC.student;

import javax.validation.constraints.NotBlank;

public class Book {

	public Book() {

	}

	public Book(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	Integer id;

	@NotBlank(message = "Kitab adı boş qoyulmamalıdır!")
	String name;
	Double price;
	String language;
	String[] authors;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;

	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

}
