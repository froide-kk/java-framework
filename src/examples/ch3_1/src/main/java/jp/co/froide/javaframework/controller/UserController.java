package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.ItemDao;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.Item;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


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



    public List<User> userList() {
        return userDao.selectAll();
    }


    public void insertUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);
    }


    public void updateUser(Integer id, String name, String password) {
        User user = userDao.selectById(id);
        user.setName(name);
        user.setPassword(password);
        userDao.update(user);
    }


    public void deleteUser(Integer id) {
        User user = userDao.selectById(id);
        userDao.delete(user);
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        List<User> list = userList();

        model.addAttribute("userList", list);
        return "hello";
    }


    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "insert";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        User user = userDao.selectById(id);
        model.addAttribute("user", user);
        return "detail";
    }

    @PostMapping(value = "insert")
    public String insert(@Validated @ModelAttribute("userForm") UserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "insert";
        }
        insertUser(form.getName(), form.getPassword());
        return "redirect:insert";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("userForm", new UserForm());
        User user = userDao.selectById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Validated @ModelAttribute("userForm") UserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        updateUser(id, form.getName(), form.getPassword());
        return "redirect:/hello";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer id) {
        //model.addAttribute("userFormId", new UserFormId());
        deleteUser(id);
        return "redirect:/hello";
    }

//    @PostMapping("/delete/{id}")
//    public String delete(@Validated @ModelAttribute("userFormId") UserForm form, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "delete";
//        }
//        deleteUser(form.getId());
//        return "redirect:/hello";
//    }

//    @Autowired
//    ItemDao itemDao;
//
//    @GetMapping("item")
//    public List<Item> itemList() {
//        return itemDao.selectAll();
//    }

//
//    public void insertItem(String name, Integer price, Date releaseDate, String imageUrl) {
//        Item item = new Item();
//        item.setName(name);
//        item.setPrice(price);
//        item.setReleaseDate(releaseDate);
//        item.setImageUrl(imageUrl);
//        itemDao.insert(item);
//    }
//
//
//    public void updateItem(Integer id, String name, Integer price, Date releaseDate, String imageUrl) {
//        Item item = itemDao.selectById(id);
//        item.setName(name);
//        item.setPrice(price);
//        item.setReleaseDate(releaseDate);
//        item.setImageUrl(imageUrl);
//        itemDao.update(item);
//    }
//
//    public void deleteItem(Integer id) {
//        Item item = itemDao.selectById(id);
//        itemDao.delete(item);
//    }
//
//    @GetMapping("/hello2")
//    public String hello(Model model) {
//        List<Item> list = itemList();
//
//        model.addAttribute("itemList", list);
//        return "hello2";
//    }
//
//
//    @GetMapping("/insert2")
//    public String insert(Model model) {
//        model.addAttribute("itemForm", new ItemForm());
//        return "insert2";
//    }
//
//    @GetMapping("/detail2/{id}")
//    public String detail(Model model, @PathVariable("id") Integer id) {
//        Item item = itemDao.selectById(id);
//        model.addAttribute("item", item);
//        return "detail2";
//    }
//
//    @PostMapping(value = "insert2")
//    public String insert(@Validated @ModelAttribute("itemForm") ItemForm form, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "insert2";
//        }
//        insertItem(form.getName(), form.getPrice(), form.getReleaseDate(), form.getImageUrl());
//        return "redirect:insert2";
//    }
//
//    @GetMapping("/update2/{id}")
//    public String update(Model model, @PathVariable("id") Integer id) {
//        model.addAttribute("itemForm", new ItemForm());
//        Item item = itemDao.selectById(id);
//        model.addAttribute("item", item);
//        return "update2";
//    }
//
//    @PostMapping("/update2/{id}")
//    public String update(@PathVariable("id") Integer id, @Validated @ModelAttribute("itemForm") ItemForm form, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "update2";
//        }
//        updateItem(id, form.getName(), form.getPrice(), form.getReleaseDate(), form.getImageUrl());
//        return "redirect:/hello2";
//    }
//
//    @GetMapping("/delete2/{id}")
//    public String delete(Model model, @PathVariable("id") Integer id) {
//        deleteItem(id);
//        return "redirect:/hello2";
//    }
}

