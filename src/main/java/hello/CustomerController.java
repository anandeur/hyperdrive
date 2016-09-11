package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/customer")
	public String customerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer";
	}

	@PostMapping("/customer")
	public String customerSubmit(@ModelAttribute Customer customer) {
		jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES(?,?)", customer.getFirstName(),
				customer.getLastName());
		return "result";
	}

	@RequestMapping("/viewCustomers")
	@ResponseBody
	public List<Customer> viewCustomers() {
		List<Customer> customerList = jdbcTemplate.query("SELECT id, first_name, last_name from customers",
				(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));
		return customerList;
	}

}
