package com.thread;

/**
 * Created by chad on 2017/4/9.
 */
public class MyThread extends Thread {
    private int i = 0;

    //继承Thread类，重写该类的run()方法
    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }


}
