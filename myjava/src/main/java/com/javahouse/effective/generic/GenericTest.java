package com.javahouse.effective.generic;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;


public class GenericTest<E> {


    @Test
    public void testGenericErase() {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();

        System.out.println(intList.getClass().getSimpleName());
        System.out.println(strList.getClass().getSimpleName());

        System.out.println(intList.getClass() == strList.getClass());
    }


    @Test
    public void testErasure() {
        Erasure<Integer> erasure = new Erasure<>();
        Class<? extends Erasure> clazz = erasure.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName() + ":" + field.getType().getSimpleName());
        }
    }


    @Test
    public void testInfo() {
        Class<InfoImpl> infoClass = InfoImpl.class;
        Method[] infoImplMethods = infoClass.getDeclaredMethods();
        for (Method method : infoImplMethods) {
            System.out.println(method.getName() + ":" + method.getReturnType().getSimpleName());
        }

    }


    @Test
    public void testGenericArray() {
        ArrayList[] list = new ArrayList[5];
        ArrayList<String>[] listArr = list;

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);

        list[0] = intList;
        String s = listArr[0].get(0);
        System.out.println(s);
    }



    @Test
    public void testTypeReference() {

        List<Integer> list = Lists.newArrayList(1, 3, 4, 8, 9);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list);
        System.out.println(jsonObject.toString());


        // 使用匿名类创建TypeReference的子类对象
//        List<Integer> list2 = jsonObject.getObject("list", new TypeReference<List<Integer>>() {});
        TypeReference2 typeReference2 = new TypeReference2<List<Integer>>() {

            @Override
            public void getData() {
                System.out.println("Class:" + getClass());
                System.out.println("Super Class:" + getClass().getSuperclass());
            }

        };
        System.out.println(typeReference2.getType());
//        typeReference2.getData();

//        System.out.println("list2: " +  list2);
    }

    private static final Optional<?> EMPTY = Optional.empty();
    public static<T> Optional<T> empty() {
        @SuppressWarnings("unchecked")
        Optional<T> t = (Optional<T>) EMPTY;
        return t;
    }

    void foo(List<?> i) {
        fooHelper(i);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }



    public void test(String item) {


        Object list = Arrays.asList("a", "b");
        List<Integer> actualList = (List<Integer>) list;

        A<?> a = new A<Integer>();
//        a.setT(1);
        a.setT(null);



        List<?> list2 = new ArrayList<String>();
//        list2.add("1");


//        @SuppressWarnings("rawtypes")
        List items = new ArrayList();
        items.add("1");
        items.add(2);
        Arrays.asList(items);
        System.out.println(String.join(",", items));


//        @SuppressWarnings("rawtypes")
        Box rawBox = new Box();
        Box<Integer> intBox = (Box<Integer>)rawBox;

    }



    @Test
    public void testGenericArray2() {
        ArrayList<String>[] listArr = new ArrayList[5];
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);
        ArrayList<String> strList = new ArrayList<>();
        strList.add("abc");

//        listArr[0] = intList;
        listArr[0] = strList;
        String s = listArr[0].get(0);
        System.out.println(s);

    }


    public class A<T> {

        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }




}
