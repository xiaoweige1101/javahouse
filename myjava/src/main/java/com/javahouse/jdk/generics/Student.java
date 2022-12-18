package com.javahouse.jdk.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

//public class Student extends Person<Integer, Boolean> {
public class Student extends Person<Integer, Boolean> {


    public static void main(String[] args) {
        Student student = new Student();
        Class clazz = student.getClass();
        // getSuperClass()获得该类的父类ß
        System.out.println(clazz.getSuperclass());

        /**
         * geGenericSupperclass()获得带有泛型的父类
         * Type是Java编程语言中所有类型的公共高级接口，它们包括原始类型、参数化类型、数组类型、类型变量和基本类型
         */
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);

        // ParameerizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType) type;

        // getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Class c1 = (Class)p.getActualTypeArguments()[0];
        System.out.println(c1);
        Class c2 = (Class)p.getActualTypeArguments()[1];
        System.out.println(c2);
    }

}
