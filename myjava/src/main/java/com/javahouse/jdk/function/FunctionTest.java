package com.javahouse.jdk.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionTest {


    /**
     * 函数式编程
     */
    @Test
    public void testFun01() {
        Function function = x -> {
            return "原生的用法实现接口" + x;
        };
        function.apply("123");
    }


    /**
     * 配置集合使用apply
     */
    @Test
    public void testFun02() {
        Function<User, String> funcUserToString = (User e) -> {
            return e.getName();
        };

        List<User> userList = Arrays.asList(
                new User("A-1", 1),
                new User("A-2", 2),
                new User("A-3", 3),
                new User("A-4", 4)
        );

        List<String> userNameList = userList.stream().map(v -> {
            return funcUserToString.apply(v);
        }).collect(Collectors.toList());
        userNameList.forEach(System.out::println);
    }


    /**
     * 配合集合使用andThen
     */
    @Test
    public void testFun03() {
        Function<User, String> fun = (User e) -> {
            return e.getName();
        };

        Function<String, String> lasterFunction = (String s) -> s.substring(0, 1).toLowerCase();




    }






    @Test
    public void testPredicate() {
        boolean judge = judge(6, (x) -> (x & 1) != 1);
        System.out.println(judge);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据:");
        eval(list, x -> true);
        // 1 2 3 4 5 6 7 8 9
        System.out.println();
        System.out.println("输出所有偶数:");
        eval(list, x -> (x & 1) != 1);
        // 2 4 6 8
        System.out.println();
        System.out.println("输出大于 3 的所有数字:");
        eval(list, x -> x > 3);
        // 4 5 6 7 8 9
        System.out.println();

        // 验证输入是否正确
        boolean valid = valid("许宣", x -> !x.isEmpty() && x.length() <= 3);
        System.out.println(valid);
    }
    public boolean judge(Integer input, Predicate<Integer> predicate) {
        return predicate.test(input);
    }
    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
    }
    public boolean valid(String name, Predicate<String> predicate) {
        return predicate.test(name);
    }


}
