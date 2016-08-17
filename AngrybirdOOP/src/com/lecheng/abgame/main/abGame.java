/**
 *
 */
package com.lecheng.abgame.main;

import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.ui.Menu;

/**
 * 游戏主程序
 *
 * @author renjianyong
 *
 */
public class abGame {
    // 控制整个游戏开关
    private static boolean loop = true;
    // 声明存放玩家信息的数组
    private static Player[] players = new Player[5];
    // 数组索引
    private static int index = 0;
    // 玩家
    private static Player player;

    // 游戏启动
    public static void start() {
        while (loop) {
            int mainType = Menu.MainUI();
            switch (mainType) {
                case 1:
                    // 玩家登录
                    Login loginUser = Menu.getPlayerUI();
                    // 验证玩家
                    PlayerManager.chkLogin(loginUser, players);
                    break;// TODO 返回最终界面 ？
                case 2:
                    // 管理员登录
                    Menu.getAdminUI();
                    boolean loginSuccess = AdminManager.chkLogin();
                    if (loginSuccess) {
                        int admintype = AdminManager.adminOp();
                        switch (admintype) {
                            case 1:// 新增玩家
                                AdminManager.addPlayer(player, players, index);
                                break;
                            case 2:// 修改玩家
                                AdminManager.modPlayer(players);
                                break;
                            case 3:// 删除玩家
                                AdminManager.delePlayer(players);
                                break;
                            case 4:
                                // 查询玩家
                                AdminManager.qureyPlayer(players);
                                break;
                            case 5:// 查询游戏
                                break;
                            case 6:// 分数统计
                                break;
                            case 7:// 参数设置
                                break;
                            case 0:// 返回
                                   // AdminManager.adminOp();
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 0:// 游戏退出
                    System.out.println("游戏退出 ！！");
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}
