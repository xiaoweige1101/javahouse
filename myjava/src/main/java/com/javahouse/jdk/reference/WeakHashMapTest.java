package com.javahouse.jdk.reference;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<Object, Object> objectMap = new WeakHashMap<Object, Object>();
        for (int i = 0; i < 1000; i++) {
            objectMap.put(i, new Object());
            System.gc();
            System.out.println("Map size:" + objectMap.size());
        }
    }
}
