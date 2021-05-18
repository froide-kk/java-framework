package jp.co.froide.javaframework.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//実態だけ作る
@Component
//継承クラス
public class UserFormValidator implements Validator {
    @Override
//    ユーザークラスかどうかを判定　Class<?> clazz
    public boolean supports(Class<?> clazz) {
        return UserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm");
        }
    }
}
