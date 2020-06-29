package com.basic.anonymous;

import com.util.log.MyLogger;

/**
 * 内部类demo
 *
 * @author Chad.long
 * Date: 2019/9/22 20:18
 * Version 1.0
 * 内部类区别： https://blog.csdn.net/qq_24735175/article/details/80506675
 */
public class InnerClassCar {
    private String brand;

    public InnerClassCar(String brand) {
        this.brand = brand;
    }

    public void start() {
        MyLogger.getLogger(InnerClassCar.class).info("启动" + this.brand);
    }

    class Engine{//非静态内部类有一个很大的优点：可以自由使用外部类的所有变量和方法
        String model;
        public Engine(String model){
            this.model = model;
        }

        public void ignite(){
            MyLogger.getLogger(InnerClassCar.class).info("发动机:" + this.model + " 点火");
        }
    }

    public static void main(String args[]){
        InnerClassCar innerClassCar = new InnerClassCar("福特福克斯");
        innerClassCar.start();

        InnerClassCar.Engine engine = innerClassCar.new Engine("EcoBoost");
        engine.ignite();
    }
}
