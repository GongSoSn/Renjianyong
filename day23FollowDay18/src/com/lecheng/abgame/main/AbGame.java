package com.lecheng.abgame.main;

import com.lecheng.abgame.bean.Score;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.ui.Menu;

/**
 * 游戏的主类
 *
 * @author renjianyong
 *
 */
public class AbGame {
    // 游戏的开始方法
    public void start() {
        AdminManager am = new AdminManager();
        PlayerManager pm = new PlayerManager();
        int type = Menu.getMainUI();
        switch (type) {
            case 1:
                // 玩家登陆
                pm.PlayerOP();
                break;
            case 2:
                // 管理员登陆
                boolean flag = am.adminChkLogin();
                if (!flag) {
                    System.out.println("三次机会以用光，游戏正在退出！！！");
                    return;
                }
                break;
            case 0:
                // 退出登陆
                System.out.println("系统正在退出，请稍后... ...");
                return;
            default:
                this.start();
                break;
        }


    }

    public static void main(String[] args) {
        Player[] players = new Player[10];
        Score login = new Score();
        AbGame ab = new AbGame();
        ab.start();
    }
}
