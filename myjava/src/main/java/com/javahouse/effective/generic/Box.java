package com.javahouse.effective.generic;

import java.util.Collections;
import java.util.List;

public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }


    public void boxTest(Box<Number> n) {

    }

    public void processStringList(List<String> stringList) {

    }
}

class TestBoxClass {

    public static void main(String[] args) {
        Box<Number> intBox = new Box<>();
        intBox.set(new Integer(1));
        intBox.set(new Double(2.1));

//        intBox.boxTest(new Box<Integer>());
        intBox.boxTest(new Box<Number>());

        intBox.processStringList(Collections.emptyList());

    }

}