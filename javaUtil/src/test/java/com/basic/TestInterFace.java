package com.basic;

import com.basic.interfaces.Car;
import com.basic.interfaces.Ea888;
import com.basic.interfaces.EcoBoost;
import com.basic.interfaces.Engine;

public class TestInterFace {
    public static void main(String[] args){
        Engine ea888 = new Ea888();

        Car car = new Car(ea888);
        car.ignitionEngine();

        /**
         * 这块很重要！！！
         */
        car.engine = new EcoBoost();
        car.ignitionEngine();
    }
}
