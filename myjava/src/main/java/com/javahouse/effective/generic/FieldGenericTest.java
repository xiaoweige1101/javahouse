package com.javahouse.effective.generic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Java虽然运行时会有类型擦除，但会保留Field的泛型信息，可通过Field.getGenericType() 取字段的泛型。
public class FieldGenericTest<T> {

    public Map<String,Integer> map = new HashMap<>();
    public List<Long> list = new ArrayList<>();
    public T data;

    public static void main(String[] args) throws Exception {
        FieldGenericTest<String> kest = new FieldGenericTest<String>();

        Field map = kest.getClass().getField("map");
        Field list = kest.getClass().getField("list");
        Field data = kest.getClass().getField("data");

        System.out.println("=====map=====");
        System.out.println("map.getType=" + map.getType());
        System.out.println("map.getGenericType=" + map.getGenericType());

        System.out.println("=====list=====");
        System.out.println("list.getType=" + list.getType());
        System.out.println("list.getGenericType=" + list.getGenericType());


        System.out.println("=====data=====");
        System.out.println("data.getType=" + data.getType());
    }
}
