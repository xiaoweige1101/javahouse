package com.javahouse.effective.data;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Serializable {

    private int age;
    private String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private void writeObject(ObjectOutputStream out) {
        System.out.println("writeObject");
    }

    private void readObject(ObjectInputStream in) {
        System.out.println("readObject");
    }

    private Object writeReplace() {
        System.out.println("writeRelace");
        return new SubKong("路人");
    }
}
