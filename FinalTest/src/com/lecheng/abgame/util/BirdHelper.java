package com.lecheng.abgame.util;

import com.lecheng.abgame.bean.Bird;
import com.lecheng.abgame.game.DataInit;
import com.lecheng.abgame.ui.Menu;

/**
 *
 * @author renjianyong
 *
 */
public class BirdHelper {
    // 选择五只小鸟
    public static Bird[] ChooseBirds() {
        Bird[] birds = new Bird[5];
        Menu.getChooseBirdUI();
        for (int i = 0; i < 5;) {
            int a = InputHelper.getInt();
            Bird bird = getBirdById(a);
            if (bird != null) {
                birds[i] = bird;
                System.out.println("您选择了一只" + bird.getBirdName() + ",您还可以选择" + (4 - i) + "只小鸟。");
                i++;
            } else {
                System.out.println("您选择的小鸟不存在，请重新选择。");
                continue;
            }
        }
        return birds;
    }


    // 根据输入的小鸟ID来选择小鸟
    public static Bird getBirdById(int id) {
        // 创建初始化信息的对象
        DataInit init = new DataInit();
        for (Bird bird : init.initBird()) {
            if (bird != null) {
                if (bird.getId() == id) {
                    return bird;
                }
            }
        }
        return null;
    }
}
