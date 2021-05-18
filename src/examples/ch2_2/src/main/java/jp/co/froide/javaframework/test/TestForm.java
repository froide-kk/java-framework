package jp.co.froide.javaframework.test;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class TestForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 1, max = 10)
    private String name;

    @NotBlank
    private String birthday;

    @NotBlank
    private String number;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;
}
