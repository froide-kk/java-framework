package jp.co.froide.javaframework.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(@RequestParam String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping
    public String hello(@ModelAttribute UserForm form) {
        return String.format("Hello %s!", form.getName());
    }

}
