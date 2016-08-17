package com.Game.cn;

/**
 * @author renjianyong 在原来game的基础之上修改优化
 */
public class AngryBirdGame {

    public static void main(String[] args) {
        boolean loop = true;
        // 声明控制新增玩家循环的开关
        boolean flag = true;
        // 声明存放玩家信息的数组
        String[] players = new String[2];
        int playersIndex = 0;
        // 首页实例化对象
        Index index = new Index();
        // 玩家登录的实例化对象
        PlayerLogin playerLogin = new PlayerLogin();
        // 管理员登录的实例化对象
        AdminLogin adminLogin = new AdminLogin();

        while (loop) {
            switch (index.index()) {
                case 1:// Login by 'Player'
                    playerLogin.playerLogin(players);
                    break;
                case 2:// Login by 'Admin'
                    adminLogin.adminLogin(players, playersIndex, flag, loop);
                    break;
                case 0:// Game Exit.. ..
                    System.out.println("游戏退出 ！！");
                    break;
                default:
                    break;
            }
        }

    }
}
