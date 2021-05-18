package jp.co.froide.javaframework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.froide.javaframework.dao.ProductDao;
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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductDao userDao;

    //一覧表示
    @GetMapping("/product")
    public String productList(Model model) {
        Collection<Product> productDataList = userDao.selectAll();
        model.addAttribute("productList", productDataList);
        return "product/productList";
    }
}
