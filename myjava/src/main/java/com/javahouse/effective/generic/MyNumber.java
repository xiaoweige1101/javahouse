package com.javahouse.effective.generic;

import java.util.ArrayList;
import java.util.List;

public class MyNumber<T extends Integer> {

    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
//        ln.add(new NaturalNumber(35));  // compile-time error
        MyNumber[] myNumbers = new MyNumber[20];


        Class<? extends Integer> clazz = Integer.class;
    }

    public static <T extends Integer> void process(List<? extends Integer> list)
    { /* ... */ }

}

class NaturalNumber {
    private int i;
    public NaturalNumber(int i) { this.i = i; }
    // ...
}

class EvenNumber extends NaturalNumber {
    public EvenNumber(int i) { super(i); }
    // ...
}