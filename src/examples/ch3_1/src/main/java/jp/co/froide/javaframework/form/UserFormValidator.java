package jp.co.froide.javaframework.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
//            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm");
//        }
        if (!userForm.password.equals(userForm.passwordConfirm)) {
            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm","これがエラ〜メッセージですよ。");
        }
    }
}

//notblankは適用されている
