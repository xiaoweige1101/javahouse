package com.javahouse.effective;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cat {

    private static Map<String, Cat> catMap = new HashMap<>();
    private static AtomicInteger cnt = new AtomicInteger(0);

    public static Cat getInstance(String name) {
        return catMap.computeIfAbsent(name, n -> new Cat(cnt.getAndAdd(1), n));
    }


    private Integer id;

    private String name;

    public Cat(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Cat cat = Cat.getInstance("mycat");
        System.out.println(cat);
        throw new RuntimeException("");
    }

}
