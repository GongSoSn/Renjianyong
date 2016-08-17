/**
 *
 */
package com.Game.cn;

import java.util.Scanner;

/**
 * @author renjianyong
 *
 */
public class Index {
    // 首页登录
    public int index() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********************************************\n");
        System.out.println("\t\t愤  怒  的  小  鸟\t\t\n");
        System.out.print("请选择登录方式:      ");
        System.out.println("1、玩家登陆           2、管理员登录        0、退出");
        System.out.println("\n**********************************************\n");
        // Login Type Choose
        int type = scanner.nextInt();
        return type;
    }
}
