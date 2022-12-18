package com.javahouse.effective.data;

//import com.sun.tools.javac.util.List;

//import com.sun.tools.javac.util.List;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet01<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet01() {

    }

    public InstrumentedHashSet01(int initCap, float loadFactor) {
        super(initCap, loadFactor);
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

    public int getAddCount() {
        return addCount;
    }

    public synchronized int read() throws IOException {
        int a = 12;
        return a & 0xff;
    }

    public static void main(String[] args) {
        InstrumentedHashSet01<String> s = new InstrumentedHashSet01<>();
//        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}
