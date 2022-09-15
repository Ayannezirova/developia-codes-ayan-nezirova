package az.developia.springsecurityayaan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String list(Model m) {

		Customer c = customerRepository.findById(4).get();

		Order o1 = new Order(null, "Seki", 45D);
		Order o2 = new Order(null, "Gence", 11D);

		o1.setCustomer(c);
		o2.setCustomer(c);

		orderRepository.save(o1);
		orderRepository.save(o2);

		c.getOrders().add(o1);
		c.getOrders().add(o2);

		customerRepository.save(c);

		List<Customer> customers = customerRepository.findAll();
		m.addAttribute("customers", customers);

		return "orders";
	}

	@GetMapping(path = "/list2")
	public String list2() {

		Customer c = new Customer();
		c.setName("Hesen");

		Order o1 = new Order(null, "Merdekan", 23D); // 23-un double oldugunu bildirmek ucun yanina "D" yazmaliyiq.
		Order o2 = new Order(null, "Baku", 50D);

		c.getOrders().add(o1);
		c.getOrders().add(o2);

		customerRepository.save(c);

		return "orders";
	}

	@GetMapping(path = "/list3")
	public String list3(Model m) {

		List<Customer> customers = customerRepository.findAll();
		m.addAttribute("customers", customers);

		return "orders";
	}

	@GetMapping(path = "/list4")
	public String list4(Model m) {

		List<Order> orders = orderRepository.findAll();
		for (Order order : orders) {
			if (order.getCustomer() != null) {
				order.getCustomer().setOrders(null);
			}
		}
		// m.addAttribute("orders", orders);
		System.out.println(orders);

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
