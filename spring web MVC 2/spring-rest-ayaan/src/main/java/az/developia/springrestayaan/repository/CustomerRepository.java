package az.developia.springrestayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrestayaan.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
