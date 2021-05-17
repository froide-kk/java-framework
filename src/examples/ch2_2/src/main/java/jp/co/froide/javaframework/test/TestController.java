package jp.co.froide.javaframework.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestFormValidator testFormValidator;

    @InitBinder("testForm")
    public void validatorBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(testFormValidator);
    }

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "world");
        model.addAttribute("testForm", new TestForm());
        return "test";
    }

    @PostMapping
    public String hello(@Validated @ModelAttribute("testForm") TestForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", "error");
        } else {
            model.addAttribute("name", form.getName());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("birthday", "error");
        } else {
            model.addAttribute("birthday", form.getBirthday());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("number", "error");
        } else {
            model.addAttribute("number", form.getNumber());
        }
        return "test";
    }

}
