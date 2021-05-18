package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("users")
    public String userList(Model model) {
        model.addAttribute("name","world");
        model.addAttribute("userForm", new UserForm());
        List<User> users;
        users = userDao.selectAll();
        model.addAttribute("users", userDao.selectAll());
        return "hello";
    }

    @PostMapping("users")
    public String insert(@ModelAttribute UserForm form) {
        User user = new User();
        user.name = form.name;
        user.password = form.password;
        userDao.insert(user);
        return "hello";
    }

    @PutMapping("users/{id}")
    public String update(@ModelAttribute UserForm form, @PathVariable("id") Integer id){
        User user = new User();
        user.id = id;
        user.name = form.name;
        user.password = form.password;
        userDao.update(user);
        List<User> users = userDao.selectAll();
        
        return "hello.u";
    }

    @DeleteMapping("users/{id}")
    public String delete(@ModelAttribute UserForm form, @PathVariable("id") Integer id){
        User user = new User();
        user.id = id;
        user.name = form.name;
        user.password = form.password;
        userDao.update(user);
        return "hello.d";
    }
}
