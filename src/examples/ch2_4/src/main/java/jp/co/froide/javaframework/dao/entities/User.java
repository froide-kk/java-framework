package jp.co.froide.javaframework.entities;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

import java.io.Serializable;

@Setter
@Getter
@Entity
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String firstName;

    private String lastName;

    private String enail;

    private String tel;

    private String zip;

    private String address;
}
