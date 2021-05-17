package jp.co.froide.javaframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public  void validatorBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(userFormValidator);
    }


    @GetMapping
    public String hello(Model model) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("name");
        arr.add("birth");
        arr.add("post_code");
        arr.add("address");
        arr.add("tel");
        for(int i=0;i< arr.size();i++) {
            model.addAttribute(arr.get(i), "");
        }

        model.addAttribute("userForm", new UserForm());
        return "hello";
    }

    @PostMapping
    public String hello(@Validated @ModelAttribute UserForm form, BindingResult bindingResult,Model model) {

        model.addAttribute("name", form.getName());
        model.addAttribute("birth",form.getBirth());
        model.addAttribute("post_code",form.getPost_code());
        model.addAttribute("address",form.getAddress());
        model.addAttribute("tel",form.getTel());
        return "hello";
    }

}
