package jp.co.froide.javaframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class JavaframeworkApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaframeworkApplication.class, args);
	}

//	@GetMapping
//	public String hello(@RequestPalam String name) {
//		return String.format("Hello %s!", name);
//	}
//
//	@PostMapping
//	public String hello(@ModelAttribute Userform form) {
//		return String.format("Hello %s!", form.getName());
//	}

//	@RequestMapping("/")
//	public String hello() {
//		return "Hello World!";
//	}



	@PostMapping("/hello")
	public String hello(@RequestParam String name) {
				System.out.println(name);
			return "hello World!";
	}
}
