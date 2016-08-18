/**
 *
 */
package com.Extends.cn;

/**
 * @author renjianyong
 *
 */
public class AnimalDriver {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Animal();

        for (int i = 0; i < animals.length; i++) {
            animals[i].eat();
            animals[i].sleep();
        }
    }
}
