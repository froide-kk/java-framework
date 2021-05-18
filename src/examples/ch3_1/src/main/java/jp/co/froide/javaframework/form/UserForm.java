package jp.co.froide.javaframework.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 1, max = 10)
    private String name;

    @NotBlank
    public String password;

    @NotBlank
    public String passwordConfirm;

    private List userList;

}
