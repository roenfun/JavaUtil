package com.java.basic;

/**
 * Created by chad on 2017/4/8.
 */
public class UpCasting {
    static class Father {
        public void foo() {
            System.out.println("One");
        }
    }

    static class Son extends Father {
        public void foo() {
            System.out.println("Two");
        }

        public void dosth() {
            System.out.println("Two again");
        }
    }

    public static void main(String[] args) throws Exception {
        Father father = new Son(); //向上转型，即父类引用指向子类对象，此时子类对象的类型为父类的类型
        father.foo(); //output: Tow
        //father.dosth();//编译错误
        father = (Son) father;
        // father.dosth();//编译错误
        ((Son) father).dosth();//编译成功, Tow again
    }
}
