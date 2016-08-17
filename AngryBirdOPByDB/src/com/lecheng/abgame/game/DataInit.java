package com.lecheng.abgame.game;

/**
 * @author renjianyong
 *
 */
public class DataInit {
    public static Bird[] birds = new Bird[3];

    // 初始化小鸟的静态代码块
    static {

        // 初始化红色小鸟
        Bird b1 = new RedBird();
        b1.setId(1);
        b1.setBirdName("红色小鸟");
        b1.setGJValue(100);
        b1.setHitValue(80);

        // 初始化蓝色小鸟
        Bird b2 = new BlueBird();
        b2.setId(2);
        b2.setBirdName("蓝色小鸟");
        b2.setGJValue(200);
        b2.setHitValue(60);

        // 初始化黑色小鸟
        Bird b3 = new BlackBird();
        b3.setId(3);
        b3.setBirdName("黑色小鸟");
        b3.setGJValue(300);
        b3.setHitValue(40);



        birds[0] = b1;
        birds[1] = b2;
        birds[2] = b3;
    }

}
