package jp.co.froide.javaframework.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class QuestionFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz){
        return QuestionForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        QuestionForm questionForm = (QuestionForm) target;
        /*if(questionForm.getSelectedRadio().equals("どちらでもない") && questionForm.getAnyAnimal().equals("")){
            errors.rejectValue("anyAnimals", "QuestionFormValidator.questionForm.anyAnimal");
        }*/

        if(!questionForm.getPassword().equals(questionForm.getPasswordConfirm())){
            errors.rejectValue("passwordConfirm", "UserFormValidator.userForm.passwordConfirm");
        }
    }

}
