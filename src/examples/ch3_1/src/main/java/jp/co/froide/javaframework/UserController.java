package jp.co.froide.javaframework;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("users")
    public String userList(Model model) {
        List<User> users = userDao.selectAll();
        model.addAttribute("users", users);
        model.addAttribute("userForm", new UserForm());
        return "hello";
    }

    //登録
    @GetMapping("users/entry")
    public String userEntryList(Model model) {
        List<User> users = userDao.selectAll();
        model.addAttribute("users",users);
        model.addAttribute("userForm", new UserForm());
        return "hello.i";
    }

    @PostMapping("users/entry")
    public String insert(@ModelAttribute UserForm form,Model model) {
        User user = new User();
        user.name = form.name;
        user.password = form.password;
        userDao.insert(user);
        List<User> users = userDao.selectAll();
        model.addAttribute("users",users);
        return "hello";
    }

    //編集
    @GetMapping("users/edit")
    public String userEditList(Model model) {
        List<User> users = userDao.selectAll();
        model.addAttribute("users", users);
        model.addAttribute("userForm", new UserForm());
        return "hello.u";
    }

    @PostMapping("users/edit")
    public String update(@ModelAttribute UserForm form,Model model){
        User user = new User();
        user.id = form.id;
        user.name = form.name;
        user.password = form.password;
        userDao.update(user);
        List<User> users = userDao.selectAll();
        model.addAttribute("users",users);
        return "redirect:/users";
    }

    //削除
    @GetMapping("users/delete")
    public String userDeleteList(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "hello.d";
    }

    @PostMapping("users/delete")
    public String delete(@ModelAttribute UserForm form){
        userDao.delete(userDao.selectById(form.id));
        return "redirect:/users";
    }
}
