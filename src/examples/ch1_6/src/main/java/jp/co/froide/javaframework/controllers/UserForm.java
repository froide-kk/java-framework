package jp.co.froide.javaframework.controllers;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message="名前を入力してください")
    private String name;
    @NotBlank(message="生年月日を入力してください")
    private String birthday;
    @NotBlank(message="郵便番号を入力してください")
    private String postaddress;
    @NotBlank(message="住所を入力してください")
    private String address;
    @NotBlank(message="電話番号を入力してください")
    private String number;
}
