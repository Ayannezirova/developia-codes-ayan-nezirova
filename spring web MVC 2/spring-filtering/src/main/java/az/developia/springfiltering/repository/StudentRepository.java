package az.developia.springfiltering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springfiltering.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
