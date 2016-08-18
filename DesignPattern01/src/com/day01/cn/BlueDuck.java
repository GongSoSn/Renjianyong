/**
 *
 */
package com.day01.cn;

import com.day01.cn.interfaces.Flyable;
import com.day01.cn.interfaces.Quackable;

/**
 * @author renjianyong
 *
 */
public class BlueDuck extends Duck implements Quackable, Flyable {

    @Override
    public void display() {
        System.out.println("这是蓝色鸭子！");
    }

    @Override
    public void fly() {
        System.out.println("Can Fly... ...");
    }

    @Override
    public void quack() {
        System.out.println("呱呱");
    }

}
