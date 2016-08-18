/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public class Cat extends Animal {
    @Override
    public void makeSound() {
        miao();
    }

    public void miao() {
        System.out.println("喵喵... ...");
    }
}
