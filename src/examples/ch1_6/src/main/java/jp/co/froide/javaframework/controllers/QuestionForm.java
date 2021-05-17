package jp.co.froide.javaframework.controllers;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class QuestionForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private String selectedRadio;

    //String anyAnimal;
    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;
}
