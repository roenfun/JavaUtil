package com.basic.classforname;

import java.util.Scanner;

/**
 * @author Chad.long
 * Date: 2019/12/27 18:02
 * Version 1.0
 */
public class ClassForName {
    /**
     * @link {https://javainterviewpoint.com/java-virtual-machine-architecture-in-java/}
     * @param args
     */
    public static void main(String args[]){
        try {
            String someClassName = "";
            Scanner in = new Scanner(System.in);
            System.out.print("Please class name with package structure\n"); //输入 com.basic.classforname.Test
            someClassName = in.nextLine();
            Class clasz = Class.forName(someClassName); //调用类静态语句
            Object object = clasz.newInstance(); //调用构造方法
        }catch ( ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
