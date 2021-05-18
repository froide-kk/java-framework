package jp.co.froide.javaframework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.Product;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserEditForm;
import jp.co.froide.javaframework.form.UserEditFormValidator;
import jp.co.froide.javaframework.form.UserForm;
import jp.co.froide.javaframework.form.UserFormValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    UserEditFormValidator userEditFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userFormValidator);
    }
    @InitBinder("userEditForm")
    public void validatorBinderEdit(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userEditFormValidator);
    }

    //一覧表示
    @GetMapping("/")
    public String userList(Model model) {
        Collection<User> userDataList = userDao.selectAll();
        model.addAttribute("userList", userDataList);
        model.addAttribute("userForm", new UserForm());
        return "userList";
    }

    //登録画面表示
    @GetMapping("/create")
    public String userCreate(Model model) {
        model.addAttribute("name", "ゲスト");
        model.addAttribute("userForm", new UserForm());
        return "userCreate";
    }

    //登録処理
    @PostMapping("/create")
    public String userPost(@Validated @ModelAttribute UserForm form, BindingResult bindingResult, Model model) throws JsonProcessingException {
        log.info("validated: {}, userForm: {}", bindingResult.hasErrors() ? "false" : "true", new ObjectMapper().writeValueAsString(form));
        if (bindingResult.hasErrors()){
            return "userCreate";
        }
        User user = new User();
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        form.getPasswordConfirm();
        userDao.insert(user);
        Collection<User> userDataList = userDao.selectAll();
        model.addAttribute("userList", userDataList);
        model.addAttribute("userForm", new UserForm());
        return "redirect:/";
    }

    //編集ページ
    @GetMapping("/edit")
    public String userEdit(Model model) {
        model.addAttribute("userEditForm", new UserEditForm());
        return "userEdit";
    }

    //編集処理
    @PostMapping("/edit")
    public String userEdit(@Validated @ModelAttribute UserEditForm userForm, BindingResult bindingResult, @RequestParam("submit") String value, Model model) throws JsonProcessingException {
        //インスタンスの生成
        User user = new User();
        //delete
        if (value.equals("削除")) {
            userDao.delete( userDao.selectById(userForm.getId()));
            return "redirect:/";
        }
        log.info("validated: {}, userForm: {}", bindingResult.hasErrors() ? "false" : "true", new ObjectMapper().writeValueAsString(userForm));
        if (bindingResult.hasErrors()){
            return "userEdit";
        }
        //put
        user.setId(userForm.getId());
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        userForm.getPasswordConfirm();
        userDao.update(user);
        Collection<User> userDataList = userDao.selectAll();
        model.addAttribute("userList", userDataList);
        model.addAttribute("userForm", new UserForm());
        return "redirect:/";
    }
}
