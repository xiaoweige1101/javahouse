package com.javahouse.jdk.lambda;

import org.junit.Test;

import java.util.function.Supplier;

public class LambdaTest {

    @Test
    public void test() {
        Supplier<User> supplier = ()->new User();
        User user = supplier.get();

        Supplier<User> supplier2 = User::new;
        User user2 = supplier2.get();
    }




    public class User {

        public User() {
            System.out.println("new user objects");
        }

    }

}
