/**
 *
 */
package com.lecheng.abgame.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.game.Bird;
import com.lecheng.abgame.game.PlayGame;
import com.lecheng.abgame.util.BirdHelper;
import com.lecheng.abgame.util.BirdInit;
import com.lecheng.abgame.util.InputHelper;

/**
 * 游戏UI模块
 *
 * @author renjianyong
 *
 */
public class Menu {
    // 主窗口
    public static int MainUI() {

        System.out.println("**********************************************\n");
        System.out.println("\t\t愤  怒  的  小  鸟\t\t\n");
        System.out.print("请选择登录方式:      ");
        System.out.println("1、玩家登陆           2、管理员登录        0、退出");
        System.out.println("\n**********************************************\n");
        int mainType = InputHelper.getInt();
        return mainType;
    }

    // 管理员模块
    public static void getAdminUI() {
        System.out.println("**********************************************\n");
        System.out.println("\t\t管 理 员 登 陆\t\t\n");
        System.out.println("请输入用户名:");
        System.out.println("请输入密码:");
        System.out.println("\n**********************************************\n");
    }

    // 游戏玩家模块
    public static Login getPlayerUI() {
        // 创建Login对象
        Login login = new Login();
        System.out.println("**********************************************\n");
        System.out.println("\t\t玩   家   登   陆\t\t\n");
        System.out.println("请输入用户名:");
        System.out.println("请输入密码:");
        System.out.println("\n**********************************************\n");
        String loginName = InputHelper.getString();
        String password = InputHelper.getString();
        login.setName(loginName);
        login.setPass(password);
        return login;
    }

    // 玩家登录成功界面
    public static void getPlayerLoginUI(Login login) {
        System.out.println(login.getName() + " 您好！您已登录...  ...");
        System.out.println("**********************************************\n");
        System.out.println("\t\t愤  怒  的  小  鸟\t\t\n");
        System.out.println("\t\t1、开始游戏           \n\t\t2、查看成绩        \n\t\t0、返回上级");
        System.out.println("\n**********************************************\n");
        System.out.println("请选择 >>>>>>");
        int playerType = InputHelper.getInt();
        boolean flag = true;
        Login showLogin = login;
        int index = 0;
        while (flag) {
            switch (playerType) {
                case 1:// 开始游戏
                    Menu.getChooseBird();
                    // 获取游戏时间
                    Calendar calender = Calendar.getInstance();
                    Date date = calender.getTime();
                    // 转换格式
                    SimpleDateFormat format = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
                    String playDate = format.format(date);


                    Bird[] birds = BirdHelper.birdChoose();
                    PlayGame start = new PlayGame();
                    start.setLogin(login);
                    start.setBirds(birds);
                    String score = start.playStart() + "";
                    showLogin.setScore(index, playDate);
                    showLogin.setScore((index + 1), score);

                    System.out.println("是否要结束游戏？ N[结束] 其他[不结束]");
                    String modFlag = InputHelper.getString();
                    if (modFlag.equalsIgnoreCase("N")) {
                        flag = false;
                        Menu.getPlayerLoginUI(login);
                    } else {
                        index++;
                    }
                    break;
                case 2:// 查询成绩
                    System.out.println("**********************************************");
                    System.out.println("当前玩家是:" + showLogin.getName());
                    System.out.println("    游戏时间\t\t\t\t游戏分数");
                    // 遍历分数数组
                    for (String s : showLogin.getScore()) {
                        // 除空
                        if (s != null) {
                            System.out.print(s + "         \t");
                        }
                    }
                    // System.out.println("**********************************************");
                    System.out.println();
                    System.out.println("是否要结束 ？ N[结束] 其他[不结束]");
                    String qureyFlag = InputHelper.getString();
                    if (qureyFlag.equalsIgnoreCase("N")) {
                        flag = false;
                        Menu.getPlayerLoginUI(login);
                    }
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }


    }

    // TODO 小鸟选择界面
    public static Bird[] getChooseBird() {
        Bird[] birds = BirdInit.birds;
        System.out.println("**********************************************\n");
        System.out.println("\t\t小 鸟 选 择 界 面\t\t\n");
        // 遍历小鸟数组
        for (int i = 0, length = birds.length; i < length; i++) {
            System.out.println("\t\t" + birds[i].getID() + "、" + birds[i].getBirdName());
        }
        System.out.println("\n**********************************************\n");
        System.out.println("请您选择作战小鸟 ！");
        return birds;
    }
}
