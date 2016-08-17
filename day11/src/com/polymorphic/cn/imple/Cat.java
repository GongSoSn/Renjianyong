/**
 *
 */
package com.polymorphic.cn.imple;

import com.polymorphic.cn.Animal;

/**
 * @author renjianyong
 *
 */
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("Cat eat method... ...");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleep method... ...");
    }

}
