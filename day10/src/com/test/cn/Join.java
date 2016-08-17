/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public class Join extends Person {
    private String name;

    public Join() {}

    public Join(String name) {
        super("Father");// 调用父类中的构造方法
        this.name = name;
    }

    @Override
    public void sayName() {
        // super().eat();
        System.out.println("My Name is " + name + " !");
        // super().eat();
        super.eat();// call eat-method from super.class
    }

    @Override
    public void eat() {
        // super.eat();
        System.out.println("(" + name + ")" + "this is a eat method... ...");
    }

    public static void main(String[] args) {
        Join join = new Join("Join");
        join.eat();
        join.sayName();
    }
}
