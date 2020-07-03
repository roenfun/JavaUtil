package com.designpattern.singleton;

/**
 * @author Chad.long
 * Date: 2019/12/27 16:24
 * Version 1.0
 */
public class SingletonExample {
    private static SingletonExample singletonExample = null;

    /**
     * Private Constructor for preventing object creation
     from outside class
     **/
    private SingletonExample(){

    }

    public static SingletonExample getInstance(){
        if (null == singletonExample){
            singletonExample = new SingletonExample();
        }

        return singletonExample;
    }

    public void
    disp()
    {
        System.out.println("disp() method called, disp被调用");
    }
}
