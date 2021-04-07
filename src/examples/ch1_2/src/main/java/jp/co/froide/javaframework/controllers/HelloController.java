package jp.co.froide.javaframework.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(@RequestParam String name) {
        return String.format("Hello %s!", name);
    }

}
