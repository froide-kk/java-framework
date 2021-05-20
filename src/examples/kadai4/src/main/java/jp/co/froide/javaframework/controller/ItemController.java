package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.ItemDao;
import jp.co.froide.javaframework.entity.Item;
import jp.co.froide.javaframework.form.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class ItemController {

    ItemRepository ir;

    @Autowired
    ItemDao itemDao;

    @GetMapping("item")
    public List<Item> itemList() {
        return ir.selectAll();
        //return itemDao.selectAll();
    }


    public void insertItem(String name, Integer price, String releaseDate, String imageUrl) {
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setReleaseDate(releaseDate);
        item.setImageUrl(imageUrl);
        itemDao.insert(item);
    }


    public void updateItem(Integer id, String name, Integer price, String releaseDate, String imageUrl) {
        Item item = itemDao.selectById(id);
        item.setName(name);
        item.setPrice(price);
        item.setReleaseDate(releaseDate);
        item.setImageUrl(imageUrl);
        itemDao.update(item);
    }

    public void deleteItem(Integer id) {
        Item item = itemDao.selectById(id);
        itemDao.delete(item);
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        List<Item> list = itemList();

        model.addAttribute("itemList", list);
        return "hello";
    }


    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("itemForm", new ItemForm());
        return "insert";
    }



    @PostMapping(value = "insert")
    public String insert(@Validated @ModelAttribute("itemForm") ItemForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "insert";
        }
        insertItem(form.getName(), form.getPrice(), form.getReleaseDate(), form.getImageUrl());
        return "redirect:/hello";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Item item = itemDao.selectById(id);
        model.addAttribute("item", item);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        ItemForm itemForm = new ItemForm();
        Item item = itemDao.selectById(id);
        itemForm.setName(item.getName());
        itemForm.setPrice(item.getPrice());
        itemForm.setReleaseDate(item.getReleaseDate());
        itemForm.setImageUrl(item.getImageUrl());
        model.addAttribute("itemForm", itemForm);
        model.addAttribute("item", item);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Validated @ModelAttribute("itemForm") ItemForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/update/"+id;
        }
        updateItem(id, form.getName(), form.getPrice(), form.getReleaseDate(), form.getImageUrl());
        return "redirect:/hello";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer id) {
        deleteItem(id);
        return "redirect:/hello";
    }

}
