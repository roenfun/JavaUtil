package com.java.callback.callback;

/**
 * Created by chad on 2017/9/14.
 */

public class Li {

    public void executeMessage(CallBack callBack, String question) {
        System.out.println("小王问的问题--->" + question);

        //模拟小李办自己的事情需要很长时间
        for (int i = 0; i < 10000; i++) {

        }

        String result = "答案是2";

        callBack.solve(result);

    }

}
