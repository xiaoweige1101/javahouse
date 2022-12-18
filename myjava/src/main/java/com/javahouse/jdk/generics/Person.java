package com.javahouse.jdk.generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Person<T1, T2> {

    public Map<Integer, String> map = new HashMap<Integer, String>();


    public static void main(String[] args) throws Exception {
        Field field = Person.class.getField("map");
        System.out.println(field.getType());
        System.out.println(field);
        Type type = field.getGenericType();
        System.out.println(type);


        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType)type;
            Type[] acType = pt.getActualTypeArguments();
            for (Type t : acType) {
                System.out.println(t);
            }
        }


    }

}
