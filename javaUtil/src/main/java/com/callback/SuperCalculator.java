package com.callback;

/**
 * Created by chad on 2017/4/21.
 */
public class SuperCalculator
{
    public void add(int a, int b, DoJob  customer)
    {
        int result = a + b;
        customer.fillBlank(a, b, result);
    }
}
