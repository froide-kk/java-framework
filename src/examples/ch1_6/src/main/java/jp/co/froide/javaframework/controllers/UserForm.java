package jp.co.froide.javaframework.controllers;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String name;
    @NotBlank
    private String birth;
    @NotBlank
    private String post_code;
    @NotBlank
    private String address;
    @NotBlank
    private String tel;
    @NotBlank
    private String password;
    @NotBlank
    private String reenterPassword;

}
