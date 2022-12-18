package com.javahouse.effective.create;

import java.io.IOException;

public class Main {

    public static void startTest() {
        try (MyAutoCloseA a = new MyAutoCloseA();
             MyAutoCloseB b = new MyAutoCloseB()) {
            a.test();   // 接收到异常抛出，所以try语句终止，运行catch语句
            b.test();   // 该代码不会执行

            // 不论try中是否有异常，都会首先自动执行close方法，然后再判断是否进入catch块
        } catch (Exception e) {
            System.out.println("Main: exception");
            System.out.println(e.getMessage());

            Throwable[] suppressed = e.getSuppressed(); // 调用方法获得一个存放所有被抑制的异常的Throwable类型的数组，并复制
            for (Throwable throwable : suppressed){
                System.out.println(throwable.getMessage()); // 打印所有被抑制的异常
            }
        }
    }

    public static void main(String[] args) throws Exception {
        startTest();
    }
}

class MyAutoCloseA implements AutoCloseable {

    public void test() throws IOException {
        System.out.println("MyAutoCloaseA: test()");
        throw new IOException("MyAutoCloaseA: test() IOException");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseA: on close()");
        throw new ClassNotFoundException("MyAutoCloaseA: close() ClassNotFoundException");
    }
}

class MyAutoCloseB implements AutoCloseable {

    public void test() throws IOException {
        System.out.println("MyAutoCloaseB: test()");
        throw new IOException("MyAutoCloaseB: test() IOException");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseB: on close()");
        throw new ClassNotFoundException("MyAutoCloaseB: close() ClassNotFoundException");
    }
}