/**
 *
 */
package com.lecheng.abgame.game;

/**
 * @author renjianyong
 *
 */
public class BlueBird extends Bird {

    @Override
    public void display() {
        System.out.println("萌萌哒的蓝色小鸟飞了过来，它的攻击能力为:" + getAtkValue() + " !");
    }

    @Override
    public void attack() {
        System.out.println("萌萌哒的蓝色小鸟开始攻击 !");
    }

}
