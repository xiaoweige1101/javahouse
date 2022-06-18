package com.javahouse.effective.singleton;

public class Elvis {

    public static final Elvis INSTANCE = new Elvis();
//    private final static byte[] data = new byte[1024 * 1024];

    private Elvis() {

    }

    public void doSomething() {

    }

    public static void main(String[] args) throws Exception {
        Elvis elvis = Elvis.INSTANCE;
        Thread.sleep(1000000);
    }
}
