package jp.co.froide.javaframework.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;


@Data
public class ItemForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 3, max = 10)
    private String name;

    @PositiveOrZero
    @NotNull
    private Integer price;

    @NotBlank
    private String releaseDate;

    @NotBlank
    private String imageURL;





}
