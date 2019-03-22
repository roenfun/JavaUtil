package com.callback.callback;

/**
 * Created by chad on 2017/9/14.
 */

public class Wang implements CallBack {
    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void askQuestion(final String question) {
        //这里用一个线程就是异步，
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, question);
            }
        }).start();

        //小王问完问题挂掉电话就去干其他的事情了，诳街去了
        play();
    }

    public void play() {
        System.out.println("我要逛街去了");
    }

    /**
     * 小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法
     */
    @Override
    public void solve(String result) {
        System.out.println("小李告诉小王的答案是--->" + result);
    }

    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        /**
         * 小王问小李问题
         */
        wang.askQuestion("1 + 1 = ?");
    }

}
