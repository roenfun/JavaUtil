package com.callback.buttonclick;

/**
 * @author Chad.long
 * Date: 2020/6/30 10:30
 * Version 1.0
 */
public class Tester {
    public static void main(String[] args) {
        Button button = new Button();
        ClickHandler clickHandler = new ClickHandler();
        //pass the clickHandler to do the default operation
        button.onClick(clickHandler);

        Button button1 = new Button();
        //pass the interface to implement own operation
        button1.onClick(new ClickEventHandler() {
            @Override
            public void handleClick() {
                System.out.println("Button Clicked");
            }
        });
    }
}
