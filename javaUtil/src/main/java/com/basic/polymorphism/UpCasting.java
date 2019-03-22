package com.basic.polymorphism;

/**
 * Created by chad on 2017/4/8.
 */
public class UpCasting {
    public static class Father {
        public Father() {
            System.out.println("constructor: Father");
        }

        public void eat() {
            System.out.println("super class: Father: eat");
        }
    }

    public static class Son extends Father {
        public Son() {
            System.out.println("constructor: Son");
        }

        public Son(String s) {
            System.out.println("constructor: Son:" + s);
        }

        public void eat(int i) {
            System.out.println("sub class: Son eat:" +i);
        }

        public void dosth(Father f) {
            if (f instanceof Son){
                f.eat();
                System.out.println("sub class of Son method: dosth");
            }
        }
    }

    public static class Daughter extends Father {
        public Daughter() {
            System.out.println("constructor: Daughter");
        }

        @Override
        public void eat() {
            System.out.println("sub class: Daughter eat");
        }

        public void dosth(Father f) {
            if (f instanceof Daughter){
                f.eat();
                System.out.println("sub class of Daughter method: dosth");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "son constructor with param";

        Father father = new Son(); //向上转型，即父类引用指向子类对象，此时子类对象的类型为父类的类型
        father.eat();
        //father.dosth();//编译错误
        Son son2 = (Son)father;
        son2.dosth(new Son());//编译成功,

        System.out.println("--------------------------");

        father = new Daughter();
        father.eat();
        // father.dosth();//编译错误
        ((Daughter) father).dosth(new Daughter());
    }
}
