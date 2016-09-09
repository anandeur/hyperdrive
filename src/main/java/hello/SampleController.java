package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/")
//	@ResponseBody
	public String index() {
		return "index";
	}

/*	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}*/
}
