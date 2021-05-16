package jp.co.froide.javaframework.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginForm implements Serializable {
    private static final long serialVersionUID = 7593564324192730932L;

    @NotEmpty
    String name;

    @NotEmpty
    String password;
}
