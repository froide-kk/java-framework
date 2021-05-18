package jp.co.froide.javaframework.test;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//実態だけ作る
@Component
//継承クラス
public class TestFormValidator implements Validator {
    @Override
//    ユーザークラスかどうかを判定　Class<?> clazz
    public boolean supports(Class<?> clazz) {
        return TestForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TestForm userForm = (TestForm) target;
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm");
        }
    }
}
