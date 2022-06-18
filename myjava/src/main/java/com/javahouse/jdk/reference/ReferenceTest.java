package com.javahouse.jdk.reference;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

public class ReferenceTest {


    @Test
    public void test1() {

        Entry[] entryList = new Entry[8];
        entryList[0] = new Entry(new Apple("apple0"));
        entryList[1] = new Entry(new Apple("apple2"));
        System.gc();

        Arrays.asList(entryList).forEach(e -> {
            if (e != null) {
                System.out.println(e + ", " + e.get());
            } else {
                System.out.println(e);
            }
        });


    }


    static class Entry extends WeakReference<Apple> {

        Object value;

        public Entry(Apple referent) {
            super(referent);
        }
    }






}
