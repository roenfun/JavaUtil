package com.basic.interfaces;

public class Car {

    public Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void ignitionEngine() {//编译期是接口的方法，运行时是实例的方法
        engine.startEngine();
    }
}
