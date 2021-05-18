package jp.co.froide.javaframework.dao;

import jp.co.froide.javaframework.entity.Product;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.builder.SelectBuilder;

import java.util.List;

@ConfigAutowireable
@Dao
public interface ProductDao {
    default int count() {
        Config config = Config.get(this);
        SelectBuilder builder = SelectBuilder.newInstance(config);
        builder.sql("select count(*) from product");
        return builder.getScalarSingleResult(int.class);
    }

    @Sql("select /*%expand*/* from product")
    @Select
    List<Product> selectAll();

    @Sql("select /*%expand*/* from product where id = /* id */0")
    @Select
    Product selectById(Integer id);

    @Insert
    int insert(Product product);

    @Update
    int update(Product product);

    @Delete
    int delete(Product product);
}
