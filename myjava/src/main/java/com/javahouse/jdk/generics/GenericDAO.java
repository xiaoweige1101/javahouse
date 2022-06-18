package com.javahouse.jdk.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDAO<T, V> {
    private Class<T> entityClass;
    protected GenericDAO() {
        Type type = getClass().getGenericSuperclass();
        System.out.println("class:" + getClass());
        System.out.println("type:" + type);
        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
        System.out.println(((ParameterizedType) type).getActualTypeArguments()[0]);
        System.out.println(((ParameterizedType) type).getActualTypeArguments()[1]);
        this.entityClass = (Class<T>) trueType;
        System.out.println(this.entityClass);
    }
}