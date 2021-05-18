package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.DbConfig;
import jp.co.froide.javaframework.dao.UserDao;

import jp.co.froide.javaframework.dsl.UserDsl;
import jp.co.froide.javaframework.entiDSL.UserEntity;
import jp.co.froide.javaframework.entity.User;
import jp.co.froide.javaframework.form.UserForm;
import jp.co.froide.javaframework.form.UserFormValidator;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Slf4jJdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder webDataBinder){ webDataBinder.addValidators(userFormValidator);}

    Config config = createConfig();
    TransactionManager tm = config.getTransactionManager();


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
        tm.required(
                () -> {
                    UserDsl userDsl = new UserDsl(config);
                    List<UserEntity> userList = userDsl.selectAll();
                    model.addAttribute("userList", userList);
                });
        System.out.println(model);
        return "test1/userList";
    }

    @GetMapping(value="/users/detail/{id}")
    public String userDetail(Model model, @PathVariable("id") Integer id){
        tm.required(
                () -> {
                    UserDsl userDsl = new UserDsl(config);
                    UserEntity user = userDsl.selectedById(id);
                    model.addAttribute("user", user);
                });
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
        UserEntity user = new UserEntity();
        user.setName(form.getName());
        user.setPassword(form.getPassword());

        tm.required(
                () -> {
                    UserDsl userDsl = new UserDsl(config);
                    userDsl.insert(user);
                });

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

        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(form.getName());
        user.setPassword(form.getPassword());

        tm.required(
                ()->{
                    UserDsl userDsl = new UserDsl(config);
                    userDsl.update(user);
                }
        );
        System.out.println(id);

        return "redirect:/users/detail/{id}";
    }

    //@DeleteMapping(value = "/users/detail/{id}/delete")
    @PostMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        tm.required(
                () -> {
                    UserDsl userDsl = new UserDsl(config);
                    UserEntity user = userDsl.selectedById(id);
                    userDsl.delete(user);
                });
        return "redirect:/users/list";

    }

    private static Config createConfig() {
        Dialect dialect = new H2Dialect();
        LocalTransactionDataSource dataSource =
                new LocalTransactionDataSource("jdbc:mysql://localhost:33306/javaframework", "root", "root");
        JdbcLogger jdbcLogger = new Slf4jJdbcLogger();
        TransactionManager transactionManager = new LocalTransactionManager(dataSource, jdbcLogger);
        return new DbConfig(dialect, dataSource, jdbcLogger, transactionManager);
    }


}
