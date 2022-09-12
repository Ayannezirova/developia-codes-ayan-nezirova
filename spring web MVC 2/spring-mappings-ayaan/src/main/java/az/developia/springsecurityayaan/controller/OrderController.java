package az.developia.springsecurityayaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springsecurityayaan.model.Customer;
import az.developia.springsecurityayaan.model.Order;
import az.developia.springsecurityayaan.repository.CustomerRepository;
import az.developia.springsecurityayaan.repository.OrderRepository;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping(path = "/list")
	public String list() {

		Customer c = customerRepository.findById(2).get();

		Order o = new Order(null, "Merdekan", 23D); // 23-un double oldugunu bildirmek ucun yanina "D" yazmaliyiq.
		Order savedOrder = orderRepository.save(o);

		c.getOrd().add(savedOrder);
		customerRepository.save(c);

		return "orders";
	}

	@GetMapping(path = "/list2")
	public String list2() {

		Customer c = new Customer();
		c.setName("Hesen");

		Order o1 = new Order(null, "Merdekan", 23D); // 23-un double oldugunu bildirmek ucun yanina "D" yazmaliyiq.
		Order o2 = new Order(null, "Baku", 50D);

		c.getOrd().add(o1);
		c.getOrd().add(o2);

		customerRepository.save(c);

		return "orders";
	}

	@PostMapping
	public String save(@ModelAttribute(name = "orders") Order order) {

		orderRepository.save(order);

		return "orders"; // orders.html

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(false);// true-bos setirleri null-a cevirir.
																	// false- bos setirleri oldugu kimi qeyd edir.
		binder.registerCustomEditor(String.class, editor);
	}
}
