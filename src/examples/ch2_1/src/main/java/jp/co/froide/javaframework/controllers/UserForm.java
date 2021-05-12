package jp.co.froide.javaframework.controllers;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @Length(min = 3, max = 5)
    private String name;
}
