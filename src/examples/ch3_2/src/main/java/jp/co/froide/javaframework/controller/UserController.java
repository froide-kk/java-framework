package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("users")
    public List<User> userList() {
        return userDao.selectAll();
    }

    @PostMapping("users")
    public List<User> addUser(@ModelAttribute UserForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        userDao.insert(user);
        return userDao.selectAll();
    }

    @PutMapping("users/{id}")
    public List<User> updateUser(@PathVariable("id") int id, @ModelAttribute UserForm form) {
        User user = userDao.selectById(id);
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        userDao.update(user);
        return userDao.selectAll();
    }

    @DeleteMapping("users/{id}")
    public List<User> deleteUser(@PathVariable("id") int id) {
        User user = userDao.selectById(id);
        userDao.delete(user);
        return userDao.selectAll();
    }

}
