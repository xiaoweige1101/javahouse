package com.javahouse.effective.create;

public class CloseTest implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("close");
        throw new Exception("close");
    }

    public static void main(String[] args) {
        try (CloseTest closeTest = new CloseTest();
            CloseTest closeTest1 = new CloseTest();) {
            System.out.println("begin to do");
        } catch (Exception e) {
            e.printStackTrace();
            e.getSuppressed();
        }
    }
}
