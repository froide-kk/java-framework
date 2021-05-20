package jp.co.froide.javaframework.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

    private String id;

}
