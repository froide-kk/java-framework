package jp.co.froide.javaframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "world");
        model.addAttribute("userForm", new UserForm());
        return "hello";
    }

    @PostMapping
    public String hello(@ModelAttribute UserForm form, Model model) {
        model.addAttribute("name", form.getName());
        return "hello";
    }





}
