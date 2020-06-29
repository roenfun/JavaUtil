package com.basic.anonymous;

/**
 * @author Chad.long
 * Date: 2019/9/21 10:33
 * Version 1.0
 * 匿名内部类测试
 */
public class AnonymousInner {
    public void testProduct(Product p) {
        System.out.println(
                "test Product->> 购买了一个" + p.getName()
                        + "，花掉了" + p.getPrice()
        );
    }

    public void testDevice(Device p) {
        System.out.println(
                "test Device->> 购买了一个" + p.getName()
                        + "，花掉了" + p.getPrice()
        );
    }

    public static void main(String[] args) {
        AnonymousInner anonymousInner = new AnonymousInner();
        // 调用test()方法时，需要传入一个Product参数，
        // 此处传入其匿名内部类的实例
        anonymousInner.testProduct(new Product() {
            @Override
            public double getPrice() {
                return 668.66;
            }

            @Override
            public String getName() {
                return "固态硬盘";
            }
        });

        AnonymousInner anonymousInner1 = new AnonymousInner();

        anonymousInner1.testDevice(new Device("显示器") {
            @Override
            public double getPrice() {
                return 999;
            }
        });
        // 调用无参数的构造器创建Device匿名实现类的对象
        Device d = new Device() {
            // 初始化块
            {
                System.out.println("匿名内部类的初始化块...");
            }

            // 实现抽象方法
            public double getPrice() {
                return 56.2;
            }

            // 重写父类的实例方法
            public String getName() {
                return "键盘";
            }
        };

        anonymousInner1.testDevice(d);
    }
}

interface Product {
    double getPrice();

    String getName();
}

abstract class Device {
    private String name;

    public abstract double getPrice();

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    // 此处省略了name的setter和getter方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}