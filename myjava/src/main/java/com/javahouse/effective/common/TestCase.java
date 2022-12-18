package com.javahouse.effective.common;

import org.junit.Test;

public class TestCase {


    @Test
    public void test() {
        User user1 = new User(18, "张三");
        User user2 = new User(18, "张三");

        System.out.println("user1.hashCode = " + user1.hashCode());
        System.out.println("user2.hashCode = " + user2.hashCode());

    }
}
