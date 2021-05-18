package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import jp.co.froide.javaframework.form.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder){ webDataBinder.addValidators(userFormValidator);}


    @GetMapping(value = "/users/post")
    public String postUser(Model model) {
        if (!model.containsAttribute("error")) {
            model.addAttribute("form", new UserForm());
        }

        System.out.println(model);


        return "test1/postDB";
    }

    @GetMapping(value = "/users/list")
    public String userList(Model model) {
        List<User> userList = userDao.selectAll();
        model.addAttribute("userList", userList);

        return "test1/userList";
    }

    @GetMapping(value="/users/detail/{id}")
    public String userDetail(Model model, @PathVariable("id") Integer id){
        User user = userDao.selectById(id);
        model.addAttribute("user", user);
        System.out.println(user.getName());
        return "test1/userDetail";
    }

    @GetMapping(value = "/users/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Integer id){
        User user = userDao.selectById(id);
        model.addAttribute("user",user);
        model.addAttribute("id",id);
        if (!model.containsAttribute("error")) {
            model.addAttribute("form", new UserForm());
        }

        return "test1/putUser";
    }

    @PostMapping(value = "/users/post")
    public String usersList(@Validated @ModelAttribute UserForm form , BindingResult result, Model model,
                            RedirectAttributes ra){
        if(result.hasErrors()){
            ra.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            ra.addFlashAttribute("error", "Please correct the errors indicated below.");
            ra.addFlashAttribute("form",form);
            System.out.println(result);
            return "redirect:/users/post";
        }
        User user = new User();
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        userDao.insert(user);

        return "redirect:/users/list";
    }

    //@PutMapping(value = "/users/{id}")
    @PostMapping(value = "/users/update/{id}")
    public String updateUser(@Validated @ModelAttribute UserForm form, BindingResult result, Model model,
                                 @PathVariable("id") Integer id, RedirectAttributes ra){
        if(result.hasErrors()){
            ra.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            ra.addFlashAttribute("error", "Please correct the errors indicated below.");
            ra.addFlashAttribute("form",form);

            return "redirect:/users/update/{id}";
        }

        User user = new User();
        user.setId(id);
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        userDao.update(user);
        System.out.println(id);

        return "redirect:/users/detail/{id}";
    }

    //@DeleteMapping(value = "/users/detail/{id}/delete")
    @PostMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        User user = userDao.selectById(id);
        System.out.println(user);
        userDao.delete(user);
        return "redirect:/users/list";

    }


}
