package com.javahouse.jdk.function;

public class MyMapTest {


    public static void main(String[] args) {
        User user = DataBuilder.build("zhang", n -> new User(n, 1));


        System.out.println(user);
    }


}
