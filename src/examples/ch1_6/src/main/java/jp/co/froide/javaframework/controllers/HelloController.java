package jp.co.froide.javaframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name");
        model.addAttribute("birthday");
        model.addAttribute("postadress");
        model.addAttribute("adress");
        model.addAttribute("number");
        model.addAttribute("userForm", new UserForm());
        return "hello";
    }

    @PostMapping
    public String hello(@Validated @ModelAttribute UserForm form, BindingResult bindingresult, Model model) {
        if (bindingresult.hasErrors()) {
            model.addAttribute("name", "ERROR");
            model.addAttribute("birthday", "ERROR");
            model.addAttribute("postaddress", "ERROR");
            model.addAttribute("address", "ERROR");
            model.addAttribute("number", "ERROR");
            return "hello";
        }

        model.addAttribute("name", form.getName());
        model.addAttribute("birthday", form.getBirthday());
        model.addAttribute("postaddress", form.getPostaddress());
        model.addAttribute("address", form.getAddress());
        model.addAttribute("number", form.getNumber());
        return "hello";
    }

}
