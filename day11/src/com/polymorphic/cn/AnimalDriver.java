/**
 *
 */
package com.polymorphic.cn;

import com.polymorphic.cn.imple.Cat;
import com.polymorphic.cn.imple.Dog;

/**
 * @author renjianyong
 *
 */
public class AnimalDriver {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.eat();
        dog.sleep();
        cat.sleep();
        cat.eat();
    }
}
