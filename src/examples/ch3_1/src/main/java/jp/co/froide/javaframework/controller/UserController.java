package jp.co.froide.javaframework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import jp.co.froide.javaframework.form.UserFormValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class UserController {


    @Autowired
    UserDao userDao;
    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userFormValidator);
    }

    //    全件取得
    @GetMapping("users")
    public String userList(Model model) {
        Collection<User> userDataList = userDao.selectAll();
        model.addAttribute("userList",userDataList);
        return "userList";
    }

    //    Userの更新
    @PutMapping("users/syousai/{userId}")
    public String userUpdate(@PathVariable("userId") Integer userId, @RequestParam String name, String password) {
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setPassword(password);
        userDao.update(user);
        userDao.selectById(userId);
//        return;
        return "syousaiform";
    }

    //    Userの削除
    @DeleteMapping("users/syousai/{userId}")
    public String userDelete(@PathVariable("userId") Integer userId) {
        User user = new User();
        user.setId(userId);
        userDao.delete(user);
        userDao.selectById(userId);
//        return;
        return "syousaiform";
    }

    //    詳細画面　一件取得
    @GetMapping("users/syousai/{userId}")
    public String syousai(@PathVariable("userId") Integer userId, Model model) {
        User userData = userDao.selectById(userId);
        String name = userData.getName();
        model.addAttribute("name", name);
        model.addAttribute("userForm", new UserForm());
        return "syousaiform";
    }

    //    登録画面　一件表示
    @GetMapping("users/touroku/{userId}")
    public String touroku(@PathVariable("userId") Integer userId, Model model) {
        User userData = userDao.selectById(userId);
        String name = userData.getName();
        model.addAttribute("name", name);
        model.addAttribute("userForm", new UserForm());
        return "tourokuform";
    }

//    登録の処理
//    パスワードが正しいかどうか
    @PostMapping("users/{userId}")
    public String hello(@Validated @ModelAttribute("userForm") UserForm form, BindingResult bindingResult, @PathVariable("userId") Integer userId, Model model) throws JsonProcessingException {
        log.info("validated: {}, userForm: {}", bindingResult.hasErrors() ? "false" : "true", new ObjectMapper().writeValueAsString(form));
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", "error");
            return "tourokuform";
        } else {
            User user = new User();
            user.setId(userId);
            user.setName(form.getName());
            user.setPassword(form.getPassword());
            userDao.insert(user);
            userDao.selectById(userId);
            return "tourokuform";
        }
    }
}

//詳細のリンクに飛ぶと、一件だけ詳細が表示される



