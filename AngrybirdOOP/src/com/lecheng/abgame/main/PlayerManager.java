/**
 *
 */
package com.lecheng.abgame.main;

import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.ui.Menu;

/**
 * 玩家操作类
 *
 * @author renjianyong
 *
 */
public class PlayerManager {
    // 封装登录玩家信息
    public static Login chkLogin(Login loginUser, Player[] players) {
        // 验证用户登录
        String loginName = null;
        String loginPass = null;
        for (Player player : players) {
            // 排除数组为空
            if (player != null) {
                loginName = player.getName();
                loginPass = player.getPass();
            }
            for (int i = 0, length = players.length; i < length; i++) {
                // 用户名和密码验证验放在循环中，避免验证的只能是最后一个输入的用户信息
                if (loginUser.getName().equals(loginName)
                        && loginUser.getPass().equals(loginPass)) {
                    Menu.getPlayerLoginUI(loginUser);
                    return loginUser;
                }
            }
        }
        return null;
    }

}
