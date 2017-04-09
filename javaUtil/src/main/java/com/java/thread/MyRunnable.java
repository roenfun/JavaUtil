package com.java.thread;

/**
 * Created by chad on 2017/4/9.
 */
public class MyRunnable implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println("My Runable Thread:" + Thread.currentThread().getName() + " " + i);
        }
    }
}
