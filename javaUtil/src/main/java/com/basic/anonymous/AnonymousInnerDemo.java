package com.basic.anonymous;

/**
 * @author Chad.long
 * Date: 2019/9/22 20:42
 * Version 1.0
 * <p>
 * 匿名内部类一般为接口或抽象类
 */

abstract class FreshKeepingFilm {
    abstract void pack();
}

public class AnonymousInnerDemo {

    public static void main(String args[]) {

        new FreshKeepingFilm() {
            @Override
            void pack() {
                System.out.println("缠上保鲜膜为香肠保鲜");
            }
        }.pack();
    }

}
