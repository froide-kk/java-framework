package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.dao.ItemDao;
import jp.co.froide.javaframework.entity.Item;
import jp.co.froide.javaframework.form.ItemForm;
import jp.co.froide.javaframework.form.ItemFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemDao itemDao;



    @GetMapping(value = "/items/post")
    public String postitem(Model model) {
        if (!model.containsAttribute("error")) {
            model.addAttribute("form", new ItemForm());
        }

        System.out.println(model);


        return "test2/postItem";
    }

    @GetMapping(value = "/items/list")
    public String itemList(Model model) {
        List<Item> itemList = itemDao.selectAll();
        model.addAttribute("itemList", itemList);

        return "test2/itemList";
    }

    @GetMapping(value="/items/detail/{id}")
    public String itemDetail(Model model, @PathVariable("id") Integer id){
        Item item = itemDao.selectById(id);
        model.addAttribute("item", item);
        System.out.println(item.getName());
        return "test2/itemDetail";
    }

    @GetMapping(value = "/items/update/{id}")
    public String updateItem(Model model, @PathVariable("id") Integer id){
        Item item = itemDao.selectById(id);
        model.addAttribute("item",item);
        model.addAttribute("id",id);
        if (!model.containsAttribute("error")) {
            ItemForm form = new ItemForm();
            form.setName(item.getName());
            form.setPrice(item.getPrice());
            form.setReleaseDate(item.getReleaseDate());
            form.setImageURL(item.getImageURL());
            model.addAttribute("form", form);
        }

        return "test2/putItem";
    }


    @PostMapping(value = "/items/post")
    public String itemsList(@Validated @ModelAttribute ItemForm form , BindingResult result, Model model,
                            RedirectAttributes ra){
        if(result.hasErrors()){
            ra.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            ra.addFlashAttribute("error", "Please correct the errors indicated below.");
            ra.addFlashAttribute("form",form);
            System.out.println(result);
            return "redirect:/items/post";
        }
        Item item = new Item();
        item.setName(form.getName());
        item.setPrice(form.getPrice());
        item.setReleaseDate(form.getReleaseDate());
        item.setImageURL(form.getImageURL());
        itemDao.insert(item);

        return "redirect:/items/list";
    }

    //@PutMapping(value = "/items/{id}")
    @PostMapping(value = "/items/update/{id}")
    public String updateitem(@Validated @ModelAttribute ItemForm form, BindingResult result, Model model,
                                 @PathVariable("id") Integer id, RedirectAttributes ra){
        if(result.hasErrors()){
            ra.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            ra.addFlashAttribute("error", "Please correct the errors indicated below.");
            ra.addFlashAttribute("form",form);

            return "redirect:/items/update/{id}";
        }

        Item item = new Item();
        item.setId(id);
        item.setName(form.getName());
        item.setPrice(form.getPrice());
        item.setReleaseDate(form.getReleaseDate());
        item.setImageURL(form.getImageURL());
        itemDao.update(item);
        System.out.println(id);

        return "redirect:/items/list";
    }

    //@DeleteMapping(value = "/items/detail/{id}/delete")
    @PostMapping(value = "/items/delete/{id}")
    public String deleteItem(@PathVariable("id") Integer id){

        Item item = itemDao.selectById(id);
        System.out.println(item);
        itemDao.delete(item);
        return "redirect:/items/list";

    }


}
