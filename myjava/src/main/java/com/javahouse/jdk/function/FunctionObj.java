package com.javahouse.jdk.function;


import org.junit.Test;

import java.util.function.Function;

/**
 * 原生的用法，实现接口
 */
public class FunctionObj implements Function {

    @Override
    public Object apply(Object o) {
        return "原生的用法实现接口" + o;
    }


    public void myfun(String input, Function function) {
        System.out.println(function.apply(input));
    }


    @Test
    public void testFun() {
        // 方式一：调用
        myfun("123", new FunctionObj());

        // 方式二：或
        Function function = new FunctionObj();
        function.apply("123");
    }


}
