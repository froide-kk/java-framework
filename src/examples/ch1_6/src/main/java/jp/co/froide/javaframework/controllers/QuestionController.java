package jp.co.froide.javaframework.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@Slf4j
@Controller
@RequestMapping("Test")
public class QuestionController {

    @Autowired
    QuestionFormValidator questionFormValidator;

    @InitBinder("questionForm")
    public void validatorBinder(WebDataBinder webDataBinder){ webDataBinder.addValidators(questionFormValidator);}




    private  HashMap<String, String> kind =new HashMap<>();
    @GetMapping("question")
    public String question (Model model){
        log.info(" ");
        kind.put("01","犬派");
        kind.put("02","猫派");
        kind.put("03", "どちらでもない");
        model.addAttribute("kind", kind);
        model.addAttribute("form", new QuestionForm());
        return "question/question";
    }

    @PostMapping("answer")
    public String getans(@Validated @ModelAttribute QuestionForm form, BindingResult result, Model model, RedirectAttributes ra){
        log.info(" ");
        /*if(result.hasErrors()){
            model.addAttribute("ans","ERROR");
            return "question/question";
        }*/
        if (result.hasErrors()){
            model.addAttribute("passwordConfirm", "ERROR");
            ra.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form),result);
            ra.addFlashAttribute(form);


            return "redirect:question";
        }
        System.out.println(form.getSelectedRadio());
        model.addAttribute("ans", form.getSelectedRadio());
        return "question/answer";
    }
}
