package az.developia.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.mylibrary.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
