package com.javahouse.effective.generic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class CaptureConversion {

    static <T> void getData(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getName() + ": " + t);
    }

    static void chapterGet(Holder<?> holder) {
        getData(holder);
    }

    public static void main(String[] args) {
        Holder<?> h1 = new Holder<B>(new B());
        System.out.println(h1.getClass());
        chapterGet(h1); // Long: 1
    }
}


class B {

}

class C {

}