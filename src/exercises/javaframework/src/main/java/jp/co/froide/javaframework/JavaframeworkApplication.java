package jp.co.froide.javaframework;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@SpringBootApplication
public class JavaframeworkApplication {
	String hello;


	public static void main(String[] args) {
		SpringApplication.run(JavaframeworkApplication.class, args);
	}

	//@RequestMapping(value = "/", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public String hello(@ModelAttribute Jsonadd jadd){
		String name = jadd.getName();
		hello = "Hello," + name;
		return hello;
	}

	@PostMapping
	public String getmessage(@RequestParam("str")String str){
		return str;
	}

}
