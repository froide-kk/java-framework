package jp.co.froide.javaframework.controller;

import jp.co.froide.javaframework.entity.Item;
import jp.co.froide.javaframework.entity.Item_;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.criteria.Entityql;

import java.util.List;

public class ItemRepository {
    private final Entityql entityql;

    public ItemRepository(Config config) {
        this.entityql = new Entityql(config);
    }

    public List<Item> selectAll(){
        Item_ i = new Item_();
        return entityql.from(i).fetch();
    }

    public Item selectById(Integer id) {
        Item_ i = new Item_();
        return entityql.from(i).where(c -> c.eq(i.id, id)).fetchOne();
    }
}
