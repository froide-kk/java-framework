package jp.co.froide.javaframework.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

@Component
public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz){
        return UserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target,Errors errors){
        UserForm userform = (UserForm) target;
        if(!userform.getPassword().equals(userform.getReenterPassword())){
            errors.rejectValue("reenterPassword","errorMassages.userForm.reenterPassword");
        }
    }
}
