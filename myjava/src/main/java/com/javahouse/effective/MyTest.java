package com.javahouse.effective;

import java.util.concurrent.ThreadLocalRandom;

public class MyTest {


    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextInt(10));
    }

}
