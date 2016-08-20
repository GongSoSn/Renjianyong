package com.lecheng.abgame.ui;

import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.game.Bird;
import com.lecheng.abgame.game.DataInit;
import com.lecheng.abgame.util.InputHelper;

/**
 * 这是菜单类 包含各种首页
 *
 * @author renjianyong
 *
 */
public class Menu {
    // 主页面
    public static int getMainUI() {
        System.out.println("**********************************************\n");
        System.out.println("\t\t愤  怒  的  小  鸟\t\t\n");
        System.out.print("请选择登录方式:      ");
        System.out.println("1、玩家登陆           2、管理员登录        0、退出");
        System.out.println("\n**********************************************\n");
        int a = InputHelper.getInt();
        return a;
    }

    // 管理员登录界面
    public static int getAdminUI() {
        System.out.println("**********************************************\n");
        System.out.println("\t\t系   统   管   理\t\t\n");
        System.out.println(
                "\t\t1、新 增 玩 家           \n\t\t2、修 改 玩 家        \n\t\t3、删 除 玩 家\n\t\t4、查 询 玩 家\n\t\t5、查 询 游 戏\n\t\t6、分 数 统 计\n\t\t7、参 数 设 置\n\t\t0、返 回");
        System.out.println("\n**********************************************\n");
        int a = InputHelper.getInt();
        return a;
    }

    // 玩家登录页面
    public static int getPlayerUI() {
        System.out.println("**********************************************\n");
        System.out.println("\t\t愤  怒  的  小  鸟\t\t\n");
        System.out.println("\t\t1、开始游戏           \n\t\t2、查看成绩        \n\t\t0、返回上级");
        System.out.println("\n**********************************************\n");
        System.out.println("请选择 >>>>>>");
        int a = InputHelper.getInt();
        return a;
    }

    // 登陆界面
    public static Player getLoginUI() {
        Player login = new Player();
        System.out.println("请输入用户名:");
        login.setName(InputHelper.getString());

        System.out.println("请输入密码:");
        login.setPass(InputHelper.getString());
        return login;
    }

    // 小鸟选择界面
    public static void getChooseBirdUI() {
        // 创建初始化信息对象
        DataInit init = new DataInit();
        System.out.println("******************************************");
        System.out.println("请选择任意的五只小鸟进行作战！");
        for (Bird bird : init.initBird()) {
            System.out.println(bird.getId() + "." + bird.getBirdName() + "，攻击力为:"
                    + bird.getGJValue() + ",命中率为:" + bird.getHitValue());
        }
        System.out.println("******************************************");
        System.out.println("请选择:");
    }

    // 参数修改界面
    public static int getModParas() {
        // 创建初始化信息的对象
        DataInit init = new DataInit();
        System.out.println("******************************************");
        for (Bird bird : init.initBird()) {
            System.out.println(bird.getId() + "." + bird.getBirdName() + "    攻击力: "
                    + bird.getGJValue() + "    命中率: " + bird.getHitValue());
        }
        System.out.println("4.管理员姓名");
        System.out.println("5.管理员密码");
        System.out.println("6.管理员最大登录次数");
        System.out.println("0.返回上级");
        System.out.println("******************************************");
        System.out.println("\n请选择具体操作:");
        int type = InputHelper.getInt();
        return type;
    }

    // 查询游戏界面
    public static void getSearchGame() {
        System.out.println("玩家姓名\t游戏次数\t攻击力等级\t游戏指数");
    }

    // 分数统计界面
    public static void getScoreUI() {
        System.out.println("玩家姓名\t游戏总分\t平均分数\t攻击力等级\t游戏指数");
    }
}
