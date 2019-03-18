package com.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by chad on 2017/4/9.
 */
public class ThreadTest {

    public static void main(String[] args) {
        /**run()方法只是调用了Thread实例的run()方法而已，它仍然运行在主线程上，而start()方法会开辟一个新的线程，
         在新的线程上调用run()方法，此时它运行在新的线程上。
         */

        //------------1, thread------------
        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread: " + Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Thread myThread1 = new MyThread();     // 创建一个新的线程  myThread1  此线程进入新建状态
                Thread myThread2 = new MyThread();     // 创建一个新的线程 myThread2 此线程进入新建状态

                myThread1.start();                     // 调用start()方法使得线程进入就绪状态
                myThread2.start();                     // 调用start()方法使得线程进入就绪状态
            }
        }

        //---------2 runnable-----------
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Runnable: " + Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                /**创建Runnable实现类的实例，并以此实例作为Thread类的target来创建Thread对象，该Thread对象才是真正的线程对象
                 */
                Runnable myRunnable = new MyRunnable(); // 创建一个Runnable实现类的对象
                Thread thread1 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
                Thread thread2 = new Thread(myRunnable);

                thread1.start(); // 调用start()方法使得线程进入就绪状态
                thread2.start();
            }
        }

        //---------3 callable-----------------
        Callable<Integer> myCallable = new MyCallable();    // 创建MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Callable:" + Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Thread thread = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
                thread.start();                      //线程进入到就绪状态
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {
            int sum = ft.get();            //取得新创建的新线程中的call()方法返回的结果
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
