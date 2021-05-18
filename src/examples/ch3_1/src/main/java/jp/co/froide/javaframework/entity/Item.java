package jp.co.froide.javaframework.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer price;
    Date releaseDate;
    String imageUrl;
}
