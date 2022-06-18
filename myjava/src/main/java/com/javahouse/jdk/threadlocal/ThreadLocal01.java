package com.javahouse.jdk.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocal01 {


    // -Xms25m -Xmx25m
    public static void main(String[] args) throws Exception {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                doSomeThing();
            });

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(100000);
    }


    public static void doSomeThing() {
        ThreadLocal<MyClass> threadLocal = new ThreadLocal<>();

        try {
            MyClass myClass = new MyClass();
            threadLocal.set(myClass);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // 解决内存泄露的核心
//            threadLocal.remove();
        }
    }


    public static class MyClass {
//        private final byte[] data;
        public final static byte[] data = new byte[1024 * 1024 * 10];
//
        public MyClass() {
//            data = new byte[1024 * 1024]; // 1mb
            System.out.println("data init, data size:" + data.length);
        }


        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("MyClass is finalized");
        }
    }
}
