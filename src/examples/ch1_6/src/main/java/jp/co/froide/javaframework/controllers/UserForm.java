package jp.co.froide.javaframework.controllers;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "名前を入力してください")
    private String name;

    @NotBlank(message = "誕生日を入力してください")
    private String birthday;

    @Digits(integer = 7, fraction = 0, message = "ハイフン無し7桁の数字を入力してください")
    private String postalcode;

    @NotBlank(message = "住所を入力してください")
    private String address;

    @NotBlank(message = "電話番号を入力してください")
    private String tel;

    @NotBlank(message = "パスワードを入力してください")
    private String password;

    @NotBlank(message = "パスワードを入力してください")
    private String passwordConfirm;

    private String animal;
}

