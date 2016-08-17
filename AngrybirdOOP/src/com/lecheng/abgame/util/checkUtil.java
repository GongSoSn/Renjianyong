/**
 *
 */
package com.lecheng.abgame.util;

import com.lecheng.abgame.bean.Player;

/**
 * @author renjianyong
 *
 */
public class checkUtil {
    public static Player checkAge(Player player) {
        boolean ageFlag = true;
        while (ageFlag) {
            System.out.println("请输入玩家年龄:");
            // 判断年龄的范围
            int checkAge = InputHelper.getInt();
            if (checkAge < 100 && checkAge > 0) {
                player.setAge(checkAge);
                ageFlag = false;
            } else {
                System.out.println("请您输入正确的年龄 ！！");
            }
        }
        return player;
    }
}
