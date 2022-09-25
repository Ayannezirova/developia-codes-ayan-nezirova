package az.developia.springrestayaan.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrestayaan.exception.MyValidationException;
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
	public void addCustomer(@Valid @RequestBody Customer customer, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyValidationException(br);
		}

		customerRepository.save(customer);
	}

	@GetMapping
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable(name = "id") Integer customerId) {
		customerRepository.deleteById(customerId);
	}

	@PutMapping // @RequestBody ile isleyir
	// @ResponseStatus(code = HttpStatus.OK)
	public void update(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}

	// rest pagination
	@GetMapping(path = "/begin/{begin}/length/{length}")
	public List<Customer> findPartial(@PathVariable(name = "begin") Integer begin,
			@PathVariable(name = "length") Integer length) {
		// select * from customers limit 0,10

		return customerRepository.findPartial(begin, length);
	}

	@ExceptionHandler
	public List<String> handleMyValidationException(MyValidationException exc) {
		BindingResult br = exc.getBr();

		List<String> messages = new ArrayList<String>();
		for (FieldError error : br.getFieldErrors()) {
			messages.add(error.getField() + ":::" + error.getDefaultMessage());
		}
		return messages;
	}
}
