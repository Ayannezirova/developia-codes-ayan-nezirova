package az.developia.springsecurityayaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecurityayaan.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
