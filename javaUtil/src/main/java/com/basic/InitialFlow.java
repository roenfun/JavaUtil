package com.basic;

/**
 * 根据运行结果可以看出，初始化顺序是:
 * 1、父类静态成员变量和静态初始化块，按在代码中出现的先后顺序
 * 2、子类静态成员变量和静态初始化块，按在代码中出现的先后顺序 
 * 3、父类非静态成员变量，按在代码中出现的先后顺序 
 * 4、父类构造器
 * 5、子类非静态成员变量，按在代码中出现的先后顺序
 * 6、子类构造器
 */
public class InitialFlow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("------Enter the main function!------");
		System.out.println();

		ChildClass childClass = new ChildClass();

		System.out.println();
		System.out.println("------Leave the main function!-------");
	}

}

class A {
	public A(int i) {
		System.out.println("A" + i + " was created!");
	}
}

class B {
	public B(int i) {
		System.out.println("Static B" + i + " was created!");
	}
}

class BaseClass {
	//3、父类非静态成员变量，按在代码中出现的先后顺序 
	//9
	A a = new A(1);
	
	static {
		System.out.println("1、父类静态成员变量和静态初始化block块，按在代码中出现的先后顺序 --> 1.BaseClass's first static block was execute!");
	}
	
	//1、父类静态成员变量和静态初始化块，按在代码中出现的先后顺序
	//2
	static B b = new B(2);
	
	static {
		System.out.println("1、父类静态成员变量和静态初始化块，按在代码中出现的先后顺序 --> 3.BaseClass's second static block was execute!");
	}

	//4、父类构造器
	//11
	public BaseClass() {
		System.out.println("4、父类构造器 --> 11.BaseClass's constructor was called!");
	}

	//3、父类非静态成员变量，按在代码中出现的先后顺序 
	//10
	A aa = new A(3);
	
	//1、父类静态成员变量和静态初始化块，按在代码中出现的先后顺序
	//4
	static B bb = new B(4);
}

class ChildClass extends BaseClass {
	//5、子类非静态成员变量，按在代码中出现的先后顺序
	//12
	A aaa = new A(5);
	
	static {
		System.out.println("2、子类静态成员变量和静态初始化块，按在代码中出现的先后顺序 --> 5.ChildClass's first static block was execute!");
	}
	
	//2、子类静态成员变量和静态初始化块，按在代码中出现的先后顺序 
	//6
	static B bbb = new B(6);
	
	static {
		System.out.println("2、子类静态成员变量和静态初始化块，按在代码中出现的先后顺序 --> 7.ChildClass's second static block was execute!");
	}

	//6、子类构造器
	//13
	public ChildClass() {
		System.out.println("6、子类构造器 --> 14.ChildClass's constructor was called!");
	}

	//5、子类非静态成员变量，按在代码中出现的先后顺序
	//12
	A aaaa = new A(7);
	
	//2、子类静态成员变量和静态初始化块，按在代码中出现的先后顺序 
	//8
	static B bbbb = new B(8);
}
