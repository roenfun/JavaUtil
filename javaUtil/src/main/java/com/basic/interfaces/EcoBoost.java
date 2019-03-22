package com.basic.interfaces;

import com.util.log.MyLogger;

public class EcoBoost implements Engine {

    private static final MyLogger mylogger = MyLogger.getLogger(Ea888.class);

    @Override
    public void startEngine() {
        mylogger.info("startEngine: EcoBoost");
    }
}
