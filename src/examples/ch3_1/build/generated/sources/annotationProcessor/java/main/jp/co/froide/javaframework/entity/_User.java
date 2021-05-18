package jp.co.froide.javaframework.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.46.0" }, date = "2021-05-18T15:51:19.521+0900")
@org.seasar.doma.EntityTypeImplementation
public final class _User extends org.seasar.doma.jdbc.entity.AbstractEntityType<jp.co.froide.javaframework.entity.User> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.46.0");
    }

    private static final _User __singleton = new _User();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<jp.co.froide.javaframework.entity.User>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __entityPropertyTypeMap;

    @SuppressWarnings("unused")
    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<jp.co.froide.javaframework.entity.User, ?>> __embeddedPropertyTypeMap;

    private _User() {
        __listenerSupplier = org.seasar.doma.internal.jdbc.entity.NullEntityListenerSuppliers.of();
        __immutable = false;
        __name = "User";
        __catalogName = "";
        __schemaName = "";
        __tableName = "user";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __list = new java.util.ArrayList<>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __map = new java.util.LinkedHashMap<>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<jp.co.froide.javaframework.entity.User, ?>> __embeddedMap = new java.util.LinkedHashMap<>(3);
        initializeMaps(__map, __embeddedMap);
        initializeIdList(__map, __idList);
        initializeList(__map, __list);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
        __embeddedPropertyTypeMap = java.util.Collections.unmodifiableMap(__embeddedMap);
    }

    private void initializeMaps(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __map, java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<jp.co.froide.javaframework.entity.User, ?>> __embeddedMap) {
        __map.put("id", new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<jp.co.froide.javaframework.entity.User, java.lang.Integer, java.lang.Integer>(jp.co.froide.javaframework.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofInteger(), "id", "", __namingType, false, __idGenerator));
        __map.put("name", new org.seasar.doma.jdbc.entity.DefaultPropertyType<jp.co.froide.javaframework.entity.User, java.lang.String, java.lang.String>(jp.co.froide.javaframework.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "name", "", __namingType, true, true, false));
        __map.put("password", new org.seasar.doma.jdbc.entity.DefaultPropertyType<jp.co.froide.javaframework.entity.User, java.lang.String, java.lang.String>(jp.co.froide.javaframework.entity.User.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "password", "", __namingType, true, true, false));
    }

    private void initializeIdList(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __map, java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __idList) {
        __idList.add(__map.get("id"));
    }

    private void initializeList(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __map, java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> __list) {
        __list.addAll(__map.values());
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    @Deprecated
    public String getTableName() {
        return getTableName(org.seasar.doma.internal.jdbc.entity.TableNames.namingFunction);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(jp.co.froide.javaframework.entity.User entity, org.seasar.doma.jdbc.entity.PreInsertContext<jp.co.froide.javaframework.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(jp.co.froide.javaframework.entity.User entity, org.seasar.doma.jdbc.entity.PreUpdateContext<jp.co.froide.javaframework.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(jp.co.froide.javaframework.entity.User entity, org.seasar.doma.jdbc.entity.PreDeleteContext<jp.co.froide.javaframework.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(jp.co.froide.javaframework.entity.User entity, org.seasar.doma.jdbc.entity.PostInsertContext<jp.co.froide.javaframework.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(jp.co.froide.javaframework.entity.User entity, org.seasar.doma.jdbc.entity.PostUpdateContext<jp.co.froide.javaframework.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(jp.co.froide.javaframework.entity.User entity, org.seasar.doma.jdbc.entity.PostDeleteContext<jp.co.froide.javaframework.entity.User> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.co.froide.javaframework.entity.User, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<jp.co.froide.javaframework.entity.User, ?, ?> getGeneratedIdPropertyType() {
        return (org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<jp.co.froide.javaframework.entity.User, ?, ?>)__entityPropertyTypeMap.get("id");
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<jp.co.froide.javaframework.entity.User, ?, ?> getVersionPropertyType() {
        return (org.seasar.doma.jdbc.entity.VersionPropertyType<jp.co.froide.javaframework.entity.User, ?, ?>)__entityPropertyTypeMap.get("null");
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<jp.co.froide.javaframework.entity.User, ?, ?> getTenantIdPropertyType() {
        return (org.seasar.doma.jdbc.entity.TenantIdPropertyType<jp.co.froide.javaframework.entity.User, ?, ?>)__entityPropertyTypeMap.get("null");
    }

    @Override
    public jp.co.froide.javaframework.entity.User newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<jp.co.froide.javaframework.entity.User, ?>> __args) {
        jp.co.froide.javaframework.entity.User entity = new jp.co.froide.javaframework.entity.User();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("password") != null) __args.get("password").save(entity);
        return entity;
    }

    @Override
    public Class<jp.co.froide.javaframework.entity.User> getEntityClass() {
        return jp.co.froide.javaframework.entity.User.class;
    }

    @Override
    public jp.co.froide.javaframework.entity.User getOriginalStates(jp.co.froide.javaframework.entity.User __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(jp.co.froide.javaframework.entity.User __entity) {
    }

    /**
     * @return the singleton
     */
    public static _User getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _User newInstance() {
        return new _User();
    }

}
