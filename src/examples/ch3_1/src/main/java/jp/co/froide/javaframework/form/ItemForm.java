package jp.co.froide.javaframework.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

@Data
public class ItemForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 1, max = 20)
    private String name;

    @NotNull
    @Positive
    private Integer price;

    @NotBlank
    private String releaseDate;

    @NotBlank
    private String imageUrl;
}