package az.developia.springrestayaan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrestayaan.model.Customer;
import az.developia.springrestayaan.repository.CustomerRepository;

@RestController
@RequestMapping(path = "/customers")
@CrossOrigin(origins = "*")
public class CustomerRestController {

	@Autowired
	public CustomerRepository customerRepository;

	@GetMapping(path = "/{id}")
	public Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerRepository.findById(id).get();

		return customer;
	}

	@PostMapping
	public void addCustomer(@RequestParam Customer customer) {
	
		customerRepository.save(customer);
	}

	@GetMapping
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
