package com.javahouse.jdk.annotation;


import com.javahouse.jdk.annotation.anno.Constraints;
import com.javahouse.jdk.annotation.anno.DBTable;
import com.javahouse.jdk.annotation.anno.SQLInteger;
import com.javahouse.jdk.annotation.anno.SQLString;

@DBTable(name = "MEMBER")
public class Member {

    @SQLString(name = "ID", value = 50, constraints = @Constraints(primaryKey = true))
    private String id;


    @SQLString(name = "NAME", value = 30)
    private String name;


    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION", value = 150, constraints = @Constraints(allowNull = true))
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
