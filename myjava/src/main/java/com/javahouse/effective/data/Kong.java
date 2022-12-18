package com.javahouse.effective.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Kong implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -7144694309484327560L;

    public String s;

    Kong(String s)
    {
        this.s = s;
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
        System.out.println("出");
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        System.out.println("入");
    }


    public static void main(String[] args) {
        String a = "张三";

        System.out.println(a.length());

        char value[] = {1, 2, 3};
        System.out.println(value.length);
    }
}