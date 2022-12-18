package com.javahouse.effective.generic;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WildcardErrorBad<N extends Integer> {

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
//        l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
        // got a CAP#2 extends Number;
        // same bound, but different types
//        l2.set(0, temp);	    // expected a CAP#1 extends Number,
        // got a Number
    }


    private <T> List<? extends T> test() {

        return null;
    }

    private <T> List<T> test2(List<? extends T> list) {

        return null;
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void getNumbers(List<? extends Integer> list) {
        for (Integer element : list) {
            System.out.println(element.intValue());
        }
    }

    static class TestTask implements Callable {

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    static class Number {
        Integer data;

        public Number(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }
    }

    static class NatureNumber extends Number {

        public NatureNumber(Integer data) {
            super(data);
        }
    }

    public static void main(String[] args) {
        int data =  Long.numberOfLeadingZeros(8 - 1);
        System.out.println(data);
    }

}