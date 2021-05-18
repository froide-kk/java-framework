package jp.co.froide.javaframework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import jp.co.froide.javaframework.form.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserDao userDao;
    UserFormValidator userFormValidator;


    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder) {

        webDataBinder.addValidators(userFormValidator);
    }

    @GetMapping
    public String userList(Model model) throws IOException {
        List<User> userlist = userDao.selectAll();
        model.addAttribute("userlist", userlist);
        return "index";
    }

    @RequestMapping("insert")
    public ModelAndView insertUser(ModelAndView modelAndView){
        modelAndView.addObject("userForm", new UserForm());
        modelAndView.setViewName("insert");
        return modelAndView;
    }

    @RequestMapping("index")
    public ModelAndView dbList(ModelAndView modelAndView){
        modelAndView.addObject("userForm", new UserForm());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping(params = "select")
    public String selectList(@Validated UserForm userForm, Model model) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();
        String json = writer.writeValueAsString(userDao.selectById(Integer.parseInt(userForm.getId())));
        model.addAttribute("select", json);
        return "index";
    }

    @PostMapping(params = "insert")
    public String insetList(@Validated UserForm userForm, User user,BindingResult result, Model model) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();
        userDao.insert(user);
        String json = writer.writeValueAsString(userDao.selectById(user.getId()));
        model.addAttribute("insert", json+"が登録されました");
        return "insert";
    }

    @PostMapping(params = "update")
    public String upDateList(@Validated UserForm userForm, User user, Model model) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();
        userDao.update(user);
        String json = writer.writeValueAsString(userDao.selectAll());
        model.addAttribute("update", json);
        return "index";
    }

    @PostMapping(params = "delete")
    public String deleteList(@Validated UserForm userForm, User user,BindingResult result, Model model) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();
        if (userDao.count() != 0) {
            userDao.delete(user);
            String json = writer.writeValueAsString(userDao.selectAll());
            model.addAttribute("delete", json);
        }
        return "index";
    }

}
