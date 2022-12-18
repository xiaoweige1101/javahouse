package com.javahouse.jdk.generics;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/4 21:09
 */
public class GenericTest<T extends Number> {


    public static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number i : list) {
            sum += i.doubleValue();;
        }
        return sum;
    }

    public static <T extends Integer>  List<T> get() {
        return Collections.emptyList();
    }


    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
        System.out.println(GenericTest.sum(list1));

        List<Double> list2 = Arrays.asList(1.1, 1.2);
        System.out.println(GenericTest.sum(list2));

        List<? super Integer> list3 = GenericTest.get();

        List<Integer> list4 = Arrays.asList(1, 2, 3);

        List<Integer> list5 = list4.stream().filter(e -> e > 1).collect(Collectors.toList());

        System.out.println(JSONObject.toJSONString(list5));

        System.out.println("123456789".substring(0, 7));

    }

}
