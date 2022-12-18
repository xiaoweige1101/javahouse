package com.javahouse.effective.data;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialbleTest {

    @Test
    public void testOut03() throws Exception
    {
        SubPeople p = new SubPeople(2,"小白");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/wei/workspace/temp01.txt"));
        out.writeObject(p);
        out.flush();
        out.close();
    }

    @Test
    public void testIn03() throws Exception
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/wei/workspace/temp01.txt"));
        Kong k = (Kong)in.readObject();
        in.close();
        System.out.println(k.s);
    }

}
