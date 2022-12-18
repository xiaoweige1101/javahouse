package com.javahouse.effective.generic;

public class TestClass {


    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(getClass());
//                System.out.println(getClass().getSuperclass());
//            }
//        });
//        thread.start();

        A a1 = new A();

        System.out.println(a1.getClass());

        A a = new A() {

        };

        System.out.println(a.getClass());
        System.out.println(a.getClass().getSuperclass());

    }






}
