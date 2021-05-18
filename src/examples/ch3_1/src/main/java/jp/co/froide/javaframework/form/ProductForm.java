package jp.co.froide.javaframework.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class ProductForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 3, max = 5)
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

    private Integer id;

    private List userList;

    private String checkbox;
}