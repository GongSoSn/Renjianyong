/**
 *
 */
package com.lecheng.abgame.main;

import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.util.InputHelper;
import com.lecheng.abgame.util.checkUtil;

/**
 * 管理员操作类
 *
 * @author renjianyong
 *
 */
public class AdminManager {

    // 声明控制新增玩家循环的开关
    private static boolean flag = true;

    // 修改玩家
    public static void modPlayer(Player[] players) {
        // 首先遍历一下玩家信息
        qureyPlayer(players);
        // ①获取需要修改的玩家(通过匹配姓名找到需要修改的玩家)
        System.out.println("请您输入需要修改的名字:");
        String modName = InputHelper.getString();
        // 判断是否存在此玩家
        for (int z = 0; z < players.length; z++) {
            // 排除数组中不符合要求的元素
            if (players[z] != null) {
                // 找到‘玩家姓名’
                String checkName = players[z].getName();
                // 验证此玩家是不是存在
                if (modName.equals(checkName)) {
                    System.out.println("您已经选中 " + modName + " 玩家，请您修改相关信息 ！");
                    // ②开始修改玩家信息(实现的功能：只能修改除了玩家姓名之外的信息)
                    System.out.println("请您输入需要修改的玩家密码 ！");
                    players[z].setPass(InputHelper.getString());
                    System.out.println("请您输入需要修改的玩家昵称 ！");
                    players[z].setNickName(InputHelper.getString());
                    System.out.println("请您输入需要修改的玩家性别 ！");
                    players[z].setSex(InputHelper.getString());
                    // 验证年龄的合理性
                    players[z] = checkUtil.checkAge(players[z]);
                    // 新修改的用户添加到数组中
                    // ①获取当前用户在数组中的索引(必须在当前的索引上修改)
                    int newIndex = z;
                    players[newIndex] = players[z];
                    System.out.println("修改玩家成功 ！");
                    return;
                } else {
                    System.out.println("玩家不存在 ！！");
                    continue;// TODO || 以后需要修改......
                }
            }
        }
    }

    // 删除玩家
    public static void delePlayer(Player[] players) {
        // 首先遍历一下玩家信息
        qureyPlayer(players);
        // ①获取需要删除的玩家(通过匹配姓名找到需要修改的玩家)
        System.out.println("请您输入需要删除的名字:");
        String deleName = InputHelper.getString();
        // 判断是否存在此玩家
        for (int z = 0; z < players.length; z++) {
            // 排除数组中不符合要求的元素
            if (players[z] != null) {
                // 找到‘玩家姓名’
                String checkName = players[z].getName();
                // 验证此玩家是不是存在
                if (deleName.equals(checkName)) {
                    // ①获取当前用户在数组中的索引(必须在当前的索引上修改)
                    int deleIndex = z;
                    players[deleIndex] = null;
                    System.out.println("删除玩家成功 ！");
                    return;
                }
            }
            continue;
        }
    }

    // 管理员操作
    public static int adminOp() {
        System.out.println("**********************************************\n");
        System.out.println("\t\t系   统   管   理\t\t\n");
        System.out.println(
                "\t\t1、新 增 玩 家           \n\t\t2、修 改 玩 家        \n\t\t3、删 除 玩 家\n\t\t4、查 询 玩 家\n\t\t5、查 询 游 戏\n\t\t6、分 数 统 计\n\t\t7、参 数 设 置\n\t\t0、返 回");
        System.out.println("\n**********************************************\n");
        int adminType = InputHelper.getInt();
        // 返回控制管理员选择条目的标识
        return adminType;
    }

    // 查询玩家
    public static void qureyPlayer(Player[] players) {
        System.out.println("已经添加的玩家信息如下：\n玩家姓名\t玩家昵称\t玩家性别\t玩家年龄");
        for (Player p : players) {
            // 排除数组元素为空的情况
            if (p != null) {
                // 查询时，密码不可见！
                System.out.println(p.getName() + "\t" + p.getNickName() + "\t" + p.getSex() + "\t"
                        + p.getAge());
            }
        }
    }

    // 新增玩家
    public static Player[] addPlayer(Player player, Player[] players, int index) {
        while (flag) {
            // 必须保证每一次循环都要重新创建一个玩家对象
            player = new Player();
            // 输入玩家相关信息
            System.out.println("请输入玩家姓名:");
            player.setName(InputHelper.getString());
            System.out.println("请输入玩家密码:");
            player.setPass(InputHelper.getString());
            System.out.println("请输入玩家昵称:");
            player.setNickName(InputHelper.getString());
            System.out.println("请输入玩家性别:");
            player.setSex(InputHelper.getString());
            // 验证年龄的合理性
            player = checkUtil.checkAge(player);
            players[index] = player;
            // 数组下标后移
            index++;
            // 提示是否结束新增玩家操作
            System.out.println("是否结束添加新增玩家？ Y [不结束] N[结束]");
            String addEnd = InputHelper.getString();
            if (addEnd.equalsIgnoreCase("N")) {
                System.out.println("您已经结束了新增玩家操作 !");
                flag = false;
            }
        }
        return players;
    }

    // 验证管理员登录
    // 登录验证
    public static boolean chkLogin() {
        String adminName = InputHelper.getString();
        String adminPwd = InputHelper.getString();
        for (int count = 1; count <= 3; count++) {
            if (adminName.equals("admin") && adminPwd.equals("admin")) {
                return true;
            } else {
                if ((3 - count) > 0) {
                    System.out.println("你还有" + (3 - count) + "机会 ！\n");
                    System.out.println("**********************************************\n");
                    System.out.println("\t\t管   理   员   登   陆\t\t\n");
                    System.out.println("请输入用户名:");
                    System.out.println("请输入密码:");
                    System.out.println("\n**********************************************\n");
                    adminName = InputHelper.getString();
                    adminPwd = InputHelper.getString();
                } else {
                    System.out.println("您的机会已经用完 ！！请重新开始登录！！");
                    return false;
                }
            }
        }
        return false;
    }

    // 管理员登录
}
