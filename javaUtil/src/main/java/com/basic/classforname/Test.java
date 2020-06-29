package com.basic.classforname;

/**
 * @author Chad.long
 * Date: 2019/12/27 18:00
 * Version 1.0
 */
public class Test {
    static {
        System.out.println("Static block called");
    }

    public Test() {
        System.out.println("Inside Test class constructor");
    }
}
