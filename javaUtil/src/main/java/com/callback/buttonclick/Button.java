package com.callback.buttonclick;

/**
 * @author Chad.long
 * Date: 2020/6/30 10:29
 * Version 1.0
 */
//Step 3: Create event generator class
public class Button {
    public void onClick(ClickEventHandler clickHandler) {
        clickHandler.handleClick();
    }

}
