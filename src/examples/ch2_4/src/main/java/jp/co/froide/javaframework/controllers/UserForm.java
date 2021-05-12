package jp.co.froide.javaframework.controllers;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 3, max = 5)
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;
}
