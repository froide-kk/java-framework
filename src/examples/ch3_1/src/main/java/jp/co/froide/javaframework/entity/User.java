package jp.co.froide.javaframework.entity;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.form.UserForm;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String password;

}
