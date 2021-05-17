package jp.co.froide.javaframework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userFormValidator);
    }

    @GetMapping
    public String hello(Model model) {
        log.info("hello");
        model.addAttribute("name", "world");
        model.addAttribute("userForm", new UserForm());
//        log.error("");
        return "hello";
    }

    @PostMapping
    public String hello(@Validated @ModelAttribute("userForm") UserForm form, BindingResult bindingResult, Model model) throws JsonProcessingException {
        log.info("validated: {}, userForm: {}", bindingResult.hasErrors() ? "false" : "true", new ObjectMapper().writeValueAsString(form));
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", "error");
        } else {
            model.addAttribute("name", form.getName());
        }
        return "hello";
    }

}
