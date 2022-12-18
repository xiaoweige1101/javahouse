package com.javahouse.effective.data;

public class Loader {


    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        System.out.println(cl);
    }


}
