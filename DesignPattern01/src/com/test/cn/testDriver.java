/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public class testDriver {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Animal cat = new Cat();

        animal.makeSound();
        cat.makeSound();
    }
}
