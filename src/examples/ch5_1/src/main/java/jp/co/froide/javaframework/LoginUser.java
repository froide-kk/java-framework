package jp.co.froide.javaframework;

import jp.co.froide.javaframework.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class LoginUser extends org.springframework.security.core.userdetails.User {

    public LoginUser(User user, Collection<? extends GrantedAuthority> authorities){
        super(String.valueOf(user.getName()), user.getPassword(), authorities);
    }

}