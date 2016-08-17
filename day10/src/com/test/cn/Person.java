/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 *         演示抽象类的使用
 */
public abstract class Person {
    private String name;

    public Person() {
        System.out.println("父类中的无参构造方法。。。 。。。(Abstract)");
    }

    public Person(String n) {
        name = n;
        System.out.println("Father Constructure !");
    }

    // 声明一个非抽象方法
    public void eat() {
        System.out.println("(Father)this is a eat Method ... ...");
    }

    // 声明一个抽象的方法
    public abstract void sayName();
}
