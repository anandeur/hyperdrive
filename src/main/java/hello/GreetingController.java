package hello;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

/*	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
*/
	@RequestMapping(value="/greeting", method=GET)
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Anand") String name, Model model) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		model.addAttribute("name",name);
		return "greeting";
	}

}