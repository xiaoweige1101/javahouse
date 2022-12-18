package com.javahouse.effective.generic;

public class InfoImpl implements Info<Integer> {


    @Override
    public Integer info(Integer value) {
        return value;
    }
}
