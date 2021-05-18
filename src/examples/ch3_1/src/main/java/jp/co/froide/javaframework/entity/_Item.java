package jp.co.froide.javaframework.entity;

import java.util.Date;

/** */
@javax.annotation.Generated(value = { "Doma", "2.46.0" }, date = "2021-05-18T13:18:55.813+0900")
@org.seasar.doma.EntityTypeImplementation
public final class _Item extends org.seasar.doma.jdbc.entity.AbstractEntityType<Item> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.46.0");
    }

    private static final _Item __singleton = new _Item();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<Item>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __entityPropertyTypeMap;

    @SuppressWarnings("unused")
    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<Item, ?>> __embeddedPropertyTypeMap;

    private _Item() {
        __listenerSupplier = org.seasar.doma.internal.jdbc.entity.NullEntityListenerSuppliers.of();
        __immutable = false;
        __name = "Item";
        __catalogName = "";
        __schemaName = "";
        __tableName = "item";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __list = new java.util.ArrayList<>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __map = new java.util.LinkedHashMap<>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<Item, ?>> __embeddedMap = new java.util.LinkedHashMap<>(3);
        initializeMaps(__map, __embeddedMap);
        initializeIdList(__map, __idList);
        initializeList(__map, __list);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
        __embeddedPropertyTypeMap = java.util.Collections.unmodifiableMap(__embeddedMap);
    }

    private void initializeMaps(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __map, java.util.Map<String, org.seasar.doma.jdbc.entity.EmbeddedPropertyType<Item, ?>> __embeddedMap) {
        __map.put("id", new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<Item, Integer, Integer>(Item.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofInteger(), "id", "", __namingType, false, __idGenerator));
        __map.put("name", new org.seasar.doma.jdbc.entity.DefaultPropertyType<Item, String, String>(Item.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "name", "", __namingType, true, true, false));
        __map.put("price", new org.seasar.doma.jdbc.entity.DefaultPropertyType<Item, Integer, Integer>(Item.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofInteger(), "price", "", __namingType, true, true, false));
        __map.put("releaseDate", new org.seasar.doma.jdbc.entity.DefaultPropertyType<Item, Date, Date>(Item.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofUtilDate(), "date", "", __namingType, true, true, false));
        __map.put("imageUrl", new org.seasar.doma.jdbc.entity.DefaultPropertyType<Item, String, String>(Item.class, org.seasar.doma.internal.jdbc.scalar.BasicScalarSuppliers.ofString(), "imageUrl", "", __namingType, true, true, false));
    }

    private void initializeIdList(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __map, java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __idList) {
        __idList.add(__map.get("id"));
    }

    private void initializeList(java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __map, java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> __list) {
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
    public void preInsert(Item entity, org.seasar.doma.jdbc.entity.PreInsertContext<Item> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(Item entity, org.seasar.doma.jdbc.entity.PreUpdateContext<Item> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(Item entity, org.seasar.doma.jdbc.entity.PreDeleteContext<Item> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(Item entity, org.seasar.doma.jdbc.entity.PostInsertContext<Item> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(Item entity, org.seasar.doma.jdbc.entity.PostUpdateContext<Item> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(Item entity, org.seasar.doma.jdbc.entity.PostDeleteContext<Item> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<Item, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<Item, ?, ?> getGeneratedIdPropertyType() {
        return (org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<Item, ?, ?>)__entityPropertyTypeMap.get("id");
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<Item, ?, ?> getVersionPropertyType() {
        return (org.seasar.doma.jdbc.entity.VersionPropertyType<Item, ?, ?>)__entityPropertyTypeMap.get("null");
    }

    @SuppressWarnings("unchecked")
    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<Item, ?, ?> getTenantIdPropertyType() {
        return (org.seasar.doma.jdbc.entity.TenantIdPropertyType<Item, ?, ?>)__entityPropertyTypeMap.get("null");
    }

    @Override
    public Item newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<Item, ?>> __args) {
        Item entity = new Item();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("price") != null) __args.get("price").save(entity);
        if (__args.get("releaseDate") != null) __args.get("releaseDate").save(entity);
        if (__args.get("imageUrl") != null) __args.get("imageUrl").save(entity);
        return entity;
    }

    @Override
    public Class<Item> getEntityClass() {
        return Item.class;
    }

    @Override
    public Item getOriginalStates(Item __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(Item __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Item getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Item newInstance() {
        return new _Item();
    }

}
