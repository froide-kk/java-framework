package jp.co.froide.javaframwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@SpringBootApplication
public class JavaframworkApplication extends HttpServlet {

	public static void main(String[] args) {
		SpringApplication.run(JavaframworkApplication.class, args);

	}
	@PostMapping
	public String hello(@RequestParam String name){
		return "Hello "+name;
	}

}
