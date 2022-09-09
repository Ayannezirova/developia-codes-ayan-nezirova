package az.developia.springsecurityayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecurityayaan.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
