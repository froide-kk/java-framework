package jp.co.froide.javaframework.dao;

import jp.co.froide.javaframework.entity.Item;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.builder.SelectBuilder;

import java.util.List;

@ConfigAutowireable
@Dao
public interface ItemDao {
    default int count() {
        Config config = Config.get(this);
        SelectBuilder builder = SelectBuilder.newInstance(config);
        builder.sql("select count(*) from items");
        return builder.getScalarSingleResult(int.class);
    }

    @Sql("select /*%expand*/* from items")
    @Select
    List<Item> selectAll();

    @Sql("select /*%expand*/* from items where id = /* id */0")
    @Select
    Item selectById(Integer id);

    @Insert
    int insert(Item item);

    @Update
    int update(Item item);

    @Delete
    int delete(Item item);
}
