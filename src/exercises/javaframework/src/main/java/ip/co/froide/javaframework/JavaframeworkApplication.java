package ip.co.froide.javaframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class JavaframeworkApplication {
	String parm = "Hello";

	public static void main(String[] args) {
		SpringApplication.run(JavaframeworkApplication.class, args);
	}

	@PostMapping
	public String hello (@RequestParam String p){
		this.parm = p;
		return p;
	}

	@GetMapping
	public String hello (){
		return this.parm;
	}
}

