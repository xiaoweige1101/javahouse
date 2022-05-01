package com.javahouse.jdk.reference;

import java.lang.ref.WeakReference;

public class Salad extends WeakReference<Apple> {


    public Salad(Apple referent) {
        super(referent);
    }

}
