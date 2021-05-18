package jp.co.froide.javaframework.test1;

import jp.co.froide.javaframework.controllers.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "world");
        model.addAttribute("userForm", new UserForm());
        return "hello";
    }

    @PostMapping
    public String hello(@ModelAttribute UserForm form, Model model) {
        model.addAttribute("name", form.getName());
        model.addAttribute("birthday", form.getBirthday());
        model.addAttribute("postaddress", form.getPostaddress());
        model.addAttribute("address", form.getAddress());
        model.addAttribute("number", form.getNumber());
        return "hello";
    }

}
