package jp.co.froide.javaframework.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;


@Getter
@Setter
@Entity(metamodel = @Metamodel)
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer price;
    String releaseDate;
    String imageUrl;
}
