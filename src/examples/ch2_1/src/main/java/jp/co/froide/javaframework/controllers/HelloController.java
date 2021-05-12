package jp.co.froide.javaframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String hello(@Validated @ModelAttribute("userForm") UserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", "error");
        } else {
            model.addAttribute("name", form.getName());
        }
        return "hello";
    }

}
