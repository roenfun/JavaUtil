package com.allure2;


import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;
import org.junit.Assert;

/**
 * @author Chad.long
 * Date: 2019-03-30 23:23
 * Version 1.0
 */
public class Allure2DemoTest {
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void testAllure2(){
//            errorCollector.checkThat(1, (2));
        Assert.assertEquals(1,1);
        Assert.assertEquals(1,2);
        Assert.assertEquals(2.01,2.00);

    }

    @Test
    public void testAllure23(){
        Assert.assertEquals(3,1);
        Assert.assertEquals(1,2);
        Assert.assertEquals(2.01,2.00);

    }

    @Test
    public void testAllure24(){
        Assert.assertEquals(3,4);
        Assert.assertEquals(2,2);
        Assert.assertEquals(2.01,2.00);

    }
}
