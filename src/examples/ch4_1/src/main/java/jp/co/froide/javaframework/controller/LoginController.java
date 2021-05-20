package jp.co.froide.javaframework.controller;


import jp.co.froide.javaframework.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @ModelAttribute
    LoginForm loginForm(){
        return new LoginForm();
    }

    /**
     * ログイン画面表示
     * @return getメソッドの時はログイン画面を表示する
     */
    @GetMapping("/loginForm")
    public String loginFrom(){
        return "login";
    }

    /**
     * 入力チェック
     *
     * @param form
     * @param br
     * @return
     */
    @PostMapping("/login")
    public String index(@Validated @ModelAttribute LoginForm form, BindingResult br) {
        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
            return "login";
        }
        return "forward:" + "/success";
    }

    /**
     * ログイン成功
     */
    @PostMapping("/success")
    public String loginsuccess(@ModelAttribute LoginForm loginForm, Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("msg","loginSuccess");
        return "success";
    }


}