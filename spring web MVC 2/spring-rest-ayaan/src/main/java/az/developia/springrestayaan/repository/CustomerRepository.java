package az.developia.springrestayaan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.springrestayaan.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from customers limit ?1,?2", nativeQuery = true)
	List<Customer> findPartial(Integer begin, Integer length);
}
