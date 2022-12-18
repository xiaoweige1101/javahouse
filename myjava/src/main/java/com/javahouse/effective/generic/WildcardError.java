package com.javahouse.effective.generic;

import java.util.List;

public class WildcardError {

    void foo(List<?> i) {
        i.set(0, null);

//        i.set(0, i.get(0));
    }
}