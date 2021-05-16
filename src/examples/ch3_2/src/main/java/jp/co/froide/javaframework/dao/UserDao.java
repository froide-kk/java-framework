package jp.co.froide.javaframework.dao;

import jp.co.froide.javaframework.entity.User;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.builder.SelectBuilder;

import java.util.List;

@ConfigAutowireable
@Dao
public interface UserDao {
    default int count() {
        Config config = Config.get(this);
        SelectBuilder builder = SelectBuilder.newInstance(config);
        builder.sql("select count(*) from user");
        return builder.getScalarSingleResult(int.class);
    }

    @Sql("select /*%expand*/* from user")
    @Select
    List<User> selectAll();

    @Sql("select /*%expand*/* from user where id = /* id */0")
    @Select
    User selectById(Integer id);

    @Insert
    int insert(User user);

    @Update
    int update(User user);

    @Delete
    int delete(User user);
}
