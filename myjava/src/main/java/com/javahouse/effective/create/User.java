package com.javahouse.effective.create;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User implements Cloneable {
    private int age;
    private String name;
    private String sex;

    private static User instance = new User();


    public User() {
//        if (instance != null) {
//            throw new RuntimeException("单例模式不允许重复创建实例!");
//        }

        System.out.println("无参构造器");
    }

    public User(int age, String name, String sex) {
//        if (instance != null) {
//            throw new RuntimeException("单例模式不允许重复创建实例!");
//        }

        System.out.println("有参构造器");
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public User clone() {
        try {
            System.out.println("clone user");
            return (User)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
