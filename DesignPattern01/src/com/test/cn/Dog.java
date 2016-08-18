/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public class Dog extends Animal {
    @Override
    public void makeSound() {
        wang();
    }

    public void wang() {
        System.out.println("汪汪... ...");
    }
}
