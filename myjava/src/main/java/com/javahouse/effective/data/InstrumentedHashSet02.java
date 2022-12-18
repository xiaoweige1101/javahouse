package com.javahouse.effective.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedHashSet02<E> extends ForWardingSet<E>  {
    private int addCount = 0;

    public InstrumentedHashSet02(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }


    public static void main(String[] args) {
        InstrumentedHashSet02<String> s = new InstrumentedHashSet02<String>(new HashSet<String>());
        s.addAll(Arrays.asList("A", "B", "C"));
        System.out.println(s.getAddCount());
    }

}

