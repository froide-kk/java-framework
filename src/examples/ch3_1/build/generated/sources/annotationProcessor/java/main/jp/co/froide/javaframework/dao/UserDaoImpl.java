package jp.co.froide.javaframework.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.46.0" }, date = "2021-05-18T15:51:19.840+0900")
@org.seasar.doma.DaoImplementation
public class UserDaoImpl implements jp.co.froide.javaframework.dao.UserDao, org.seasar.doma.jdbc.ConfigProvider {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.46.0");
    }

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(jp.co.froide.javaframework.dao.UserDao.class, "selectAll");

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(jp.co.froide.javaframework.dao.UserDao.class, "selectById", java.lang.Integer.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(jp.co.froide.javaframework.dao.UserDao.class, "insert", jp.co.froide.javaframework.entity.User.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(jp.co.froide.javaframework.dao.UserDao.class, "update", jp.co.froide.javaframework.entity.User.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.DaoImplSupport.getDeclaredMethod(jp.co.froide.javaframework.dao.UserDao.class, "delete", jp.co.froide.javaframework.entity.User.class);

    private final org.seasar.doma.internal.jdbc.dao.DaoImplSupport __support;

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public UserDaoImpl(org.seasar.doma.jdbc.Config config) {
        __support = new org.seasar.doma.internal.jdbc.dao.DaoImplSupport(config);
    }

    @Override
    public org.seasar.doma.jdbc.Config getConfig() {
        return __support.getConfig();
    }

    @Override
    public int count() {
        __support.entering("jp.co.froide.javaframework.dao.UserDaoImpl", "count");
        try {
            int __result = jp.co.froide.javaframework.dao.UserDao.super.count();
            __support.exiting("jp.co.froide.javaframework.dao.UserDaoImpl", "count", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.UserDaoImpl", "count", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.co.froide.javaframework.entity.User> selectAll() {
        __support.entering("jp.co.froide.javaframework.dao.UserDaoImpl", "selectAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("jp.co.froide.javaframework.dao.UserDao#selectAll");
            __query.setEntityType(jp.co.froide.javaframework.entity._User.getSingletonInternal());
            __query.setCallerClassName("jp.co.froide.javaframework.dao.UserDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.co.froide.javaframework.entity.User>> __command = __support.getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.co.froide.javaframework.entity.User>(jp.co.froide.javaframework.entity._User.getSingletonInternal()));
            java.util.List<jp.co.froide.javaframework.entity.User> __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.UserDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.UserDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public jp.co.froide.javaframework.entity.User selectById(java.lang.Integer id) {
        __support.entering("jp.co.froide.javaframework.dao.UserDaoImpl", "selectById", id);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = __support.getQueryImplementors().createSqlFileSelectQuery(__method2);
            __query.setMethod(__method2);
            __query.setConfig(__support.getConfig());
            __query.setSqlFilePath("jp.co.froide.javaframework.dao.UserDao#selectById");
            __query.setEntityType(jp.co.froide.javaframework.entity._User.getSingletonInternal());
            __query.addParameter("id", java.lang.Integer.class, id);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.UserDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<jp.co.froide.javaframework.entity.User> __command = __support.getCommandImplementors().createSelectCommand(__method2, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<jp.co.froide.javaframework.entity.User>(jp.co.froide.javaframework.entity._User.getSingletonInternal()));
            jp.co.froide.javaframework.entity.User __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.UserDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.UserDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(jp.co.froide.javaframework.entity.User user) {
        __support.entering("jp.co.froide.javaframework.dao.UserDaoImpl", "insert", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<jp.co.froide.javaframework.entity.User> __query = __support.getQueryImplementors().createAutoInsertQuery(__method3, jp.co.froide.javaframework.entity._User.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(__support.getConfig());
            __query.setEntity(user);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.UserDaoImpl");
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
            __support.exiting("jp.co.froide.javaframework.dao.UserDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.UserDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(jp.co.froide.javaframework.entity.User user) {
        __support.entering("jp.co.froide.javaframework.dao.UserDaoImpl", "update", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<jp.co.froide.javaframework.entity.User> __query = __support.getQueryImplementors().createAutoUpdateQuery(__method4, jp.co.froide.javaframework.entity._User.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(__support.getConfig());
            __query.setEntity(user);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.UserDaoImpl");
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
            __support.exiting("jp.co.froide.javaframework.dao.UserDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.UserDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(jp.co.froide.javaframework.entity.User user) {
        __support.entering("jp.co.froide.javaframework.dao.UserDaoImpl", "delete", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<jp.co.froide.javaframework.entity.User> __query = __support.getQueryImplementors().createAutoDeleteQuery(__method5, jp.co.froide.javaframework.entity._User.getSingletonInternal());
            __query.setMethod(__method5);
            __query.setConfig(__support.getConfig());
            __query.setEntity(user);
            __query.setCallerClassName("jp.co.froide.javaframework.dao.UserDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = __support.getCommandImplementors().createDeleteCommand(__method5, __query);
            int __result = __command.execute();
            __query.complete();
            __support.exiting("jp.co.froide.javaframework.dao.UserDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            __support.throwing("jp.co.froide.javaframework.dao.UserDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
