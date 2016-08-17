/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public class Cat extends Animal {

    /**
     * @param name
     */
    public Cat(String name) {
        super(name);
    }

    public static void main(String[] args) {
        // Animal animal = new Animal("");
        Cat cat = new Cat("name");
        System.out.println(cat.getName());
    }
}
