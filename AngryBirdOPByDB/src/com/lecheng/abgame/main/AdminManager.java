package com.lecheng.abgame.main;

import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.exception.PlayerNameSameException;
import com.lecheng.abgame.ui.Menu;
import com.lecheng.abgame.util.InputHelper;
import com.lecheng.abgame.util.PlayerHelper;
import com.lecheng.abgame.util.checkUtil;

public class AdminManager {
    Player[] players = null;
    Login login = new Login();
    // 定义一个数组下标
    int index = 0;

    // 有参构造器
    public AdminManager(Player[] players) {
        this.players = players;
    }

    // 无参构造器
    public AdminManager() {

    }

    // 判断管理员是否登陆成功
    public boolean chkLogin() {
        Login login = Menu.getLoginUI();
        if (login.getName().equalsIgnoreCase("admin")
                && login.getPass().equalsIgnoreCase("admin")) {
            return true;
        }
        return false;
    }

    // 管理员登陆 需要三次验证
    public boolean adminChkLogin() {
        boolean loop = false;
        for (int i = 1; i <= 3; i++) {
            loop = this.chkLogin();
            if (loop) {
                break;
            } else {
                if (3 - i > 0) {
                    System.out.println("您的用户名密码输入有误，您还有" + (3 - i) + "次机会。");
                }
            }
        }
        if (loop) {
            // 开始进入管理员操作界面
            this.adminOP();
        }
        return loop;
    }

    public void adminOP() {
        int adminType;
        adminType = Menu.getAdminUI();
        switch (adminType) {
            case 1:
                // 新增玩家
                // 定义循环开关
                boolean loopFlag = true;
                while (loopFlag) {
                    Player player = PlayerHelper.getPlayerData();
                    this.addPlayer(player);
                    // 数组索引后移
                    index++;
                    System.out.println("新增玩家成功！");
                    System.out.println("是否新增玩家? [N 结束   其他  继续]");
                    String s = InputHelper.getString();
                    if ("N".equalsIgnoreCase(s)) {
                        loopFlag = false;
                    }
                }
                this.adminOP();
                break;
            case 2:// 修改玩家
                modPlayer();
                this.adminOP();
                break;
            case 3:// 删除玩家
                delePlayer();
                this.adminOP();
                break;
            case 4:
                // 查询玩家
                this.queryPlayer();
                this.adminOP();
                break;
            case 0:
                AbGame ab = new AbGame();
                ab.start(players, login);
                break;
            default:
                break;
        }
    }

    public void modPlayer() {
        // 首先遍历一下玩家信息
        queryPlayer();
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
                    try {
                        String playerName = checkUtil.checkName();
                        PlayerNameSameException.checkNameSame(playerName, players);
                        players[z].setName(playerName);
                        players[z].setPass(checkUtil.checkPass());
                        players[z].setNickName(checkUtil.checkNickName());
                        players[z].setSex(checkUtil.checkSex());
                        players[z].setAge(checkUtil.checkAge());
                        // 新修改的用户添加到数组中
                        // ①获取当前用户在数组中的索引(必须在当前的索引上修改)
                        int newIndex = z;
                        players[newIndex] = players[z];
                        System.out.println("修改玩家成功 ！");
                    } catch (PlayerNameSameException e) {
                        System.out.println("修改用户失败！！！");
                    }
                    return;
                } else {
                    // System.out.println("玩家不存在 ！！");
                    continue;// TODO || 以后需要修改......
                }
            }
        }
    }

    // 删除玩家
    public void delePlayer() {
        // 首先遍历一下玩家信息
        queryPlayer();
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

    // 新增玩家方法
    public void addPlayer(Player player) {
        if (players == null) {
            players = new Player[20];
            players[index] = player;
            System.out.println("新增玩家成功！");
        } else {
            // 验证玩家姓名的唯一性
            try {
                PlayerNameSameException.checkNameSame(player.getName(), players);
                players[index] = player;
                System.out.println("添加用户成功！");
            } catch (PlayerNameSameException e) {
                System.out.println("错误代码是:" + e.getErrCode() + "\n" + "错误信息是:" + e.getErrMsg()
                        + "\n" + "添加用户失败... ...");
            }
        }

    }

    // 查询玩家方法
    public void queryPlayer() {
        System.out.println("已经添加的玩家信息如下：\n玩家姓名\t玩家昵称\t玩家性别\t玩家年龄");
        for (Player player : players) {
            // 去空
            if (player != null && player.getName().length() > 0) {
                System.out.println(player.getName() + "\t" + player.getNickName() + "\t"
                        + player.getSex() + "\t" + player.getAge());
            }
        }
    }
}
