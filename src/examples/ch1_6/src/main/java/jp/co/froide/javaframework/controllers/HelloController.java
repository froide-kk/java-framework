package jp.co.froide.javaframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.logging.Logger;

@Slf4j
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder) { webDataBinder.addValidators(userFormValidator);}


    @GetMapping
    public String hello(Model model) {
        log.info("ああああああああああ");
        log.trace("trace");
        log.error("eerro");
        log.warn("wwaaan");
        model.addAttribute("name", "world");
        model.addAttribute("password","");
        model.addAttribute("passwordConfirm","");
        /*model.addAttribute("birth", "");
        model.addAttribute("code", "");
        model.addAttribute("address", "");
        model.addAttribute("tel", "");*/

        model.addAttribute("userForm", new UserForm());
        return "hello";
    }



    @PostMapping
        public String hello(@Validated @ModelAttribute UserForm form, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("name", "ERROR");

            return "hello";
        }
        model.addAttribute("name",  form.getName() );
        /*model.addAttribute("birth", "生年月日： " + form.getBirth());
        model.addAttribute("code", "郵便番号： " + form.getCode());
        model.addAttribute("address", "住所： " + form.getAddress());
        model.addAttribute("tel", "電話番号： " + form.getTel());*/

        return "hello";
    }



}
