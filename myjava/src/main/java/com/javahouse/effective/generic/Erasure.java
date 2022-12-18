package com.javahouse.effective.generic;

public class Erasure<T extends Number> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <E> void show(E t){

    }


}
