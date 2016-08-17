/**
 *
 */
package com.polymorphic.cn.imple;

import com.polymorphic.cn.Animal;

/**
 * @author renjianyong
 *
 */
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("Dog eat method... ...");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleep method... ...");
    }

}
