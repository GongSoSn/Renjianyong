package com.lecheng.abgame.bean;

public class RedBird extends Bird {

    @Override
    public void display() {
        System.out.println("帅气的" + getBirdName() + "冲了过来，它的攻击能力为:" + getGJValue());
    }

    @Override
    public void attack() {
        System.out.println("帅气的" + getBirdName() + "开始攻击了。。。。。。。。");
    }

}
