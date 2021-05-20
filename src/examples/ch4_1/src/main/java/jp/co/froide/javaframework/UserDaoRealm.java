package jp.co.froide.javaframework;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.entity.User;
import org.seasar.doma.jdbc.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//      実際の認証処置を行う
@Component
public class UserDaoRealm implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = null;
        List<GrantedAuthority> authorityList = null;

        try{
            //ユーザを取得して、セッションに保存
            user = userDao.selectByName(name);
            if (user == null) {
                throw new UsernameNotFoundException("no user found. [id=]" + name + "]");
            }

//            ユーザテーブルと権限テーブルとそのひたつを紐付けるテーブル
            //役割キーにプレフィックスをつけてまとめる
            Set<String> roleKeys = new HashSet<>();

            //権限キーをまとめる
            Set<String> permissionKeys = new HashSet<>();

            //役割と権限を両方ともGrantedAuthorityとして渡す
            Set<String> authorities = new HashSet<>();
            authorities.addAll(roleKeys);
            authorities.addAll(permissionKeys);
            authorityList = AuthorityUtils.createAuthorityList(authorities.toArray(new String[0]));
        }catch (Exception e){
            // 0件例外がスローされた場合は何もしない
            // それ以外の場合は、認証エラーの例外で包む
            if(!(e instanceof NoResultException)){
                throw new UsernameNotFoundException("could not select user,", e);
            }
        }
        return new LoginUser(user, authorityList);
    }
}
