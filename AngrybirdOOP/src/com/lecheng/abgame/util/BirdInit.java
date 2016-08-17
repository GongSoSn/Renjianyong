/**
 *
 */
package com.lecheng.abgame.util;

import com.lecheng.abgame.game.Bird;
import com.lecheng.abgame.game.BlackBird;
import com.lecheng.abgame.game.BlueBird;
import com.lecheng.abgame.game.RedBird;

/**
 * 在游戏开始的时候创建出作战小鸟
 *
 * @author renjianyong
 *
 */
public class BirdInit {
    // 创建存放作战小鸟数组
    public static Bird[] birds = new Bird[3];

    static {
        // 创建作战各类小鸟对象
        Bird redBird = new RedBird();
        Bird blueBird = new BlueBird();
        Bird blackBird = new BlackBird();
        redBird.setBirdName("红色小鸟");
        redBird.setID(1);
        redBird.setAtkValue(80);
        redBird.setHitValue(50);

        blueBird.setID(2);
        blueBird.setAtkValue(60);
        blueBird.setBirdName("蓝色小鸟");
        blueBird.setHitValue(60);

        blackBird.setID(3);
        blackBird.setAtkValue(50);
        blackBird.setBirdName("黑色小鸟");
        blackBird.setHitValue(70);
        // 小鸟对象放入到数组中
        birds[0] = redBird;
        birds[1] = blueBird;
        birds[2] = blackBird;
    }
}
