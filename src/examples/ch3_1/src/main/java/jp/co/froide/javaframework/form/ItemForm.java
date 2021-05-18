package jp.co.froide.javaframework.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

@Data
public class ItemForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 3, max = 5)
    private String name;

    @Positive
    private Integer price;


    private Date releaseDate;

    @NotBlank
    private String imageUrl;
}
