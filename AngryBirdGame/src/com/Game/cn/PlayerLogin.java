/**
 *
 */
package com.Game.cn;

import java.util.Scanner;

/**
 * @author renjianyong
 *
 */
public class PlayerLogin {

    // 玩家登录
    public void playerLogin(String[] players) {
        System.out.println("**********************************************\n");
        System.out.println("\t\t玩   家   登   陆\t\t\n");
        System.out.println("请输入用户名:");
        System.out.println("请输入密码:");
        System.out.println("\n**********************************************\n");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        String userPwd = scanner.next();
        // 遍历玩家信息
        String loginName = null;
        String loginPass = null;
        for (String player : players) {
            // 排除数组为空
            if (player != null && player != "") {
                String[] loginUser = player.split("&");
                // for (int i = 0; i < players.length; i++) {
                loginName = loginUser[0];
                loginPass = loginUser[1];
                // 用户名和密码验证验放在循环中，避免验证的只能是最后一个输入的用户信息
                if (userName.equals(loginName) && userPwd.equals(loginPass)) {
                    System.out.println(loginName + " 您好！您已登录成功！");
                    System.out.println("**********************************************\n");
                    System.out.println("\t\t愤  怒  的  小  鸟\t\t\n");
                    System.out.println("\t\t1、开始游戏           \n\t\t2、查看成绩        \n\t\t0、返回上级");
                    System.out.println("\n**********************************************\n");
                }
            }
        }
    }
}
