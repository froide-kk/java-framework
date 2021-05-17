package jp.co.froide.javaframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String hello(Model model) {
        log.info("hello");
        //logger.trace("Hello Trace");
        //logger.debug("Hello Debug");
        //logger.info("Hello Info");
        //logger.warn("Hello Warn");
        //logger.error("Hello Error");
        model.addAttribute("name");
        model.addAttribute("birthday");
        model.addAttribute("postalcode");
        model.addAttribute("address");
        model.addAttribute("tel");
        model.addAttribute("password");
        //model.addAttribute("animal");
        model.addAttribute("userForm", new UserForm());
        return "hello";
    }


    @PostMapping("/")
    public String hello(@Validated @ModelAttribute("userForm") UserForm form, BindingResult br, Model model) {
        model.addAttribute("name", form.getName());
        model.addAttribute("birthday", form.getBirthday());
        model.addAttribute("postalcode", form.getPostalcode());
        model.addAttribute("address", form.getAddress());
        model.addAttribute("tel", form.getTel());
        model.addAttribute("password", form.getPassword());
        if (br.hasErrors()) {
            logger.error("Hello Error");
            return "hello";
        }
        //return "hello";
        return "question";
    }
    @PostMapping(value = "/send")
    public String result(@ModelAttribute UserForm form, Model model) {

        model.addAttribute("animal", form.getAnimal());
        return "result";
    }
    @GetMapping("/send")
    public String result(Model model) {
        model.addAttribute("name");
        model.addAttribute("birthday");
        model.addAttribute("postalcode");
        model.addAttribute("address");
        model.addAttribute("tel");
        model.addAttribute("animal");
        model.addAttribute("userForm", new UserForm());
        return "result";
    }


}
