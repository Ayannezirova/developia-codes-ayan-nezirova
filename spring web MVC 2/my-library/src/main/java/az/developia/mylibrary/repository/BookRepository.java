package az.developia.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.mylibrary.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
