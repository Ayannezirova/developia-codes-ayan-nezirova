package Developia.spring.web.MVC.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Developia.spring.web.MVC.student.model.Book;
import Developia.spring.web.MVC.student.repository.BookRepository;

@Service
//bu sinif repository sinifinden gelen melumati goturub controller sinifine kocurecek.
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> findThemAll() {
		//List<Book> l=bookRepository.findAll();
		//int j=0
		//for(Book bkss:l){j++; bkss.setCounter(j);}
		
		return bookRepository.findAll();
	}

	public void save(Book b) {
		bookRepository.save(b);
	}

	public void deletedId(Integer bookId) {
		bookRepository.deletedId(bookId);
	}

}
