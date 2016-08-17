/**
 *
 */
package com.lecheng.abgame.util;

import com.lecheng.abgame.game.Bird;

/**
 * @author renjianyong
 *
 */
public class BirdHelper {

    // 根据ID选择小鸟
    public static Bird[] birdChoose() {
        Bird[] birds = new Bird[5];
        for (int i = 0, length = birds.length; i < length;) {
            int id = InputHelper.getInt();
            Bird bird = getBirdByID(id);
            if (bird != null) {
                birds[i] = bird;
                System.out.println(
                        "您选择了一只" + bird.getBirdName() + "您还可以选择" + (length - (i + 1)) + "只小鸟 !");
                i++;
            } else {
                System.out.println("没有此类型的小鸟，请重新选择 ！！");
                continue;
            }
        }
        return birds;
    }

    public static Bird getBirdByID(int id) {
        for (Bird bird : BirdInit.birds) {
            if (bird != null && bird.getID() == id) {
                return bird;
            }
        }
        return null;
    }
}
