package com.lecheng.abgame.bean;

public class BlueBird extends Bird {

    @Override
    public void display() {
        System.out.println("萌萌哒的" + getBirdName() + "飞了过来，它的攻击能力为:" + getGJValue());
    }

    @Override
    public void attack() {
        System.out.println("萌萌哒的" + getBirdName() + "开始攻击了。。。。。。。。");
    }

}
