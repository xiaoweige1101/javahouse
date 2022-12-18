package com.javahouse.effective.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardFixed {

    void foo(List<?> i) {
//        i.set(0, i.get(0));
        fooHelper(i);
    }


    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

    public static void main(String[] args) {
        List<?> list = Arrays.asList("1", "2", "3");

        new WildcardFixed().foo(list);
    }


    public <K, V> boolean test() {
        return true;
    }

}


