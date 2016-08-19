package com.lecheng.abgame.game;

public class BlackBird extends Bird {

    @Override
    public void display() {
        System.out.println("笨重的黑色小鸟飞了过来，它的攻击能力为:" + getGJValue());
    }

    @Override
    public void attack() {
        System.out.println("笨重的黑色小鸟开始攻击了。。。。。。。。");
    }

}
