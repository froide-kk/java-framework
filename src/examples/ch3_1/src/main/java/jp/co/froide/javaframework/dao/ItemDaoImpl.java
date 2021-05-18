package jp.co.froide.javaframework.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.46.0" }, date = "2021-05-18T13:18:56.093+0900")
@org.seasar.doma.DaoImplementation
public class ItemDaoImpl implements ItemDao, org.seasar.doma.jdbc.ConfigProvider {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.46.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(ItemDao.class, "selectAll");

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(ItemDao.class, "selectById", Integer.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(ItemDao.class, "insert", jp.co.froide.javaframework.entity.Item.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(ItemDao.class, "update", jp.co.froide.javaframework.entity.Item.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(ItemDao.class, "delete", jp.co.froide.javaframework.entity.Item.class);

    private final org.seasar.doma.internal.jdbc.dao.DaoImplSupport __support;

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ItemDaoImpl(org.seasar.doma.jdbc.Config config) {
        __support = new org.seasar.doma.internal.jdbc.dao.DaoImplSupport(config);
    }

    @Override
    public org.seasar.doma.jdbc.Config getConfig() {
        return __support.getConfig();
    }

    @Override
    public int count() {
        __support.entering("jp.co.froide.javaframework.dao.ItemDaoImpl", "count");
        try {
            int __result = ItemDao.super.count();
            __support.exiting("jp.co.froide.javaframework.dao.ItemDaoImpl", "count", __result);
            return __result;
        } catch (RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.ItemDaoImpl", "count", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.co.froide.javaframework.entity.Item> selectAll() {
        __support.entering("jp.co.froide.javaframework.dao.ItemDaoImpl", "selectAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("jp.co.froide.javaframework.dao.ItemDao#selectAll");
            __query.setEntityType(jp.co.froide.javaframework.entity._Item.getSingletonInternal());
            __query.setCallerClassName("jp.co.froide.javaframework.dao.ItemDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.co.froide.javaframework.entity.Item>> __command = __support.getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.co.froide.javaframework.entity.Item>(jp.co.froide.javaframework.entity._Item.getSingletonInternal()));
            java.util.List<jp.co.froide.javaframework.entity.Item> __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.ItemDaoImpl", "selectAll", __result);
            return __result;
        } catch (RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.ItemDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public jp.co.froide.javaframework.entity.Item selectById(Integer id) {
        __support.entering("jp.co.froide.javaframework.dao.ItemDaoImpl", "selectById", id);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method2);
            __query.setMethod(__method2);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("jp.co.froide.javaframework.dao.ItemDao#selectById");
            __query.setEntityType(jp.co.froide.javaframework.entity._Item.getSingletonInternal());
            __query.addParameter("id", Integer.class, id);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.ItemDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<jp.co.froide.javaframework.entity.Item> __command = __support.getCommandImplementors().createSelectCommand(__method2, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<jp.co.froide.javaframework.entity.Item>(jp.co.froide.javaframework.entity._Item.getSingletonInternal()));
            jp.co.froide.javaframework.entity.Item __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.ItemDaoImpl", "selectById", __result);
            return __result;
        } catch (RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.ItemDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(jp.co.froide.javaframework.entity.Item item) {
        __support.entering("jp.co.froide.javaframework.dao.ItemDaoImpl", "insert", item);
        try {
            if (item == null) {
                throw new org.seasar.doma.DomaNullPointerException("item");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<jp.co.froide.javaframework.entity.Item> __query = __support.getQueryImplementors().createAutoInsertQuery(__method3, jp.co.froide.javaframework.entity._Item.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(__support.getConfig());
            __query.setEntity(item);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.ItemDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = __support.getCommandImplementors().createInsertCommand(__method3, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.ItemDaoImpl", "insert", __result);
            return __result;
        } catch (RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.ItemDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(jp.co.froide.javaframework.entity.Item item) {
        __support.entering("jp.co.froide.javaframework.dao.ItemDaoImpl", "update", item);
        try {
            if (item == null) {
                throw new org.seasar.doma.DomaNullPointerException("item");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<jp.co.froide.javaframework.entity.Item> __query = __support.getQueryImplementors().createAutoUpdateQuery(__method4, jp.co.froide.javaframework.entity._Item.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(__support.getConfig());
            __query.setEntity(item);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.ItemDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = __support.getCommandImplementors().createUpdateCommand(__method4, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.ItemDaoImpl", "update", __result);
            return __result;
        } catch (RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.ItemDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(jp.co.froide.javaframework.entity.Item item) {
        __support.entering("jp.co.froide.javaframework.dao.ItemDaoImpl", "delete", item);
        try {
            if (item == null) {
                throw new org.seasar.doma.DomaNullPointerException("item");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<jp.co.froide.javaframework.entity.Item> __query = __support.getQueryImplementors().createAutoDeleteQuery(__method5, jp.co.froide.javaframework.entity._Item.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(__support.getConfig());
            __query.setEntity(item);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.ItemDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = __support.getCommandImplementors().createDeleteCommand(__method5, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.ItemDaoImpl", "delete", __result);
            return __result;
        } catch (RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.ItemDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
