package com.callback.buttonclick;

/**
 * @author Chad.long
 * Date: 2020/6/30 10:28
 * Version 1.0
 */
//Step 2: Create a callback handler
public class ClickHandler implements ClickEventHandler{
    @Override
    public void handleClick() {
        System.out.println("Clicked");
    }
}
