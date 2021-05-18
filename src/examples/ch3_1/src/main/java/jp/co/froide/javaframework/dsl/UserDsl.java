package jp.co.froide.javaframework.dsl;

import jp.co.froide.javaframework.entiDSL.UserEntity;
import jp.co.froide.javaframework.entiDSL.UserEntity_;
import jp.co.froide.javaframework.entity.User;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.criteria.Entityql;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class UserDsl {

    private  final Entityql entityql;


    public UserDsl(Config config) {
        Objects.requireNonNull(config);
        this.entityql = new Entityql(config);
    }

    public List<UserEntity> selectAll(){
        UserEntity_ u = new UserEntity_();
        return entityql.from(u).fetch();
    }

    public UserEntity selectedById(Integer id){
        UserEntity_ u = new UserEntity_();
        return entityql.from(u).where(c ->c.eq(u.id, id)).fetchOne();
    }

    public void insert(UserEntity user){
        UserEntity_ u = new UserEntity_();
        entityql.insert(u, user).execute();
    }

    public void delete(UserEntity user){
        UserEntity_ u = new UserEntity_();
        entityql.delete(u, user).execute();
    }

    public  void update(UserEntity user){
        UserEntity_ u = new UserEntity_();
        entityql.update(u, user).execute();
    }

}
