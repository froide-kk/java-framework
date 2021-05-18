package jp.co.froide.javaframework.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserEditFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserEditForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserEditForm userEditForm = (UserEditForm) target;
        if (!userEditForm.getPassword().equals(userEditForm.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm","間違っていますよ");
            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm","間違っていますよ");
        }
    }
}
