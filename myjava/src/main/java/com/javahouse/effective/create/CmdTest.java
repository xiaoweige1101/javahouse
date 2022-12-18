package com.javahouse.effective.create;


import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.Constructor;

@Data
@Accessors(chain = true)
public class CmdTest {


    public static void main(String[] args) throws Exception {
//        User u = new User();
//        User u2 = new User(1, "jay", "boy");
//        User.class.getConstructor().newInstance();

//        User u = new User();
//        u.setName("u");
//        User u2 = u.clone();
//        u2.setName("u2");
//
//        Constructor constructor = User.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        User u3 = (User)constructor.newInstance();
//        u3.setName("u3");

    }


}
