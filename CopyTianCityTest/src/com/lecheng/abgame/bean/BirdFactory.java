/**
 *
 */
package com.lecheng.abgame.bean;

/**
 * @author renjianyong
 *
 */
public class BirdFactory {
    // 生产红色小鸟对象
    public static Bird RedBird() {
        return new RedBird();
    }

    // 生产蓝色小鸟对象
    public static Bird BlueBird() {
        return new BlueBird();
    }

    // 生产黑色小鸟对象
    public static Bird BlackBird() {
        return new BlackBird();
    }
}
