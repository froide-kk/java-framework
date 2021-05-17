package jp.co.froide.javaframework.controllers;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d{4}/\\d{1,2}/\\d{1,2}")
    private String birth;
    @NotBlank
    @Pattern(regexp = "^[0-9]{3}-[0-9]{4}$")
    private String code;
    @NotBlank
    private String address;
    @NotBlank
    @Pattern(regexp = "^0[789]0-[0-9]{4}-[0-9]{4}$")
    private String tel;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

}
