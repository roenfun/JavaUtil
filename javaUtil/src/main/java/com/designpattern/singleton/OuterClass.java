package com.designpattern.singleton;

/**
 * @author Chad.long
 * Date: 2019/12/27 16:29
 * Version 1.0
 */
public class OuterClass {
    public static void main(String[] args){
        SingletonExample singletonExample = SingletonExample.getInstance();
        singletonExample.disp();
    }
}
