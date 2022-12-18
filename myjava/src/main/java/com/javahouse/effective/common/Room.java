package com.javahouse.effective.common;


//import sun.misc.Cleaner;

public class Room implements AutoCloseable {

//    private static final Cleaner cleaner = Cleaner.create();


    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

//    private final State state;
//
//    private final Cleaner.Cleanable cleanable


    @Override
    public void close() throws Exception {

    }
}
