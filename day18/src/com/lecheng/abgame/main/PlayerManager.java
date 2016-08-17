package com.lecheng.abgame.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.game.Bird;
import com.lecheng.abgame.game.PlayGame;
import com.lecheng.abgame.ui.Menu;
import com.lecheng.abgame.util.BirdHelper;
import com.lecheng.abgame.util.InputHelper;

public class PlayerManager {

    AbGame ab = new AbGame();
    Player[] players = null;
    Login login = null;


    // 无参构造器
    public PlayerManager() {

    }

    // 有参构造器
    public PlayerManager(Player[] players, Login login) {
        this(login);
        this.players = players;
    }

    /**
     * @param login
     */
    public PlayerManager(Login login) {
        this.login = login;
    }

    // 判断玩家是否登陆成功
    public Login chkLogin() {
        // 获取的是键盘输入的用户名和密码
        Login login = Menu.getLoginUI();
        for (Player player : players) {
            // 去空
            if (player != null && player.getName().length() > 0) {
                if (login.getName().equals(player.getName())
                        && login.getPass().equals(player.getPass())) {
                    return login;
                }
            }
        }
        return null;
    }

    // 玩家登陆方法
    public void PlayerOP() {
        // 验证通过之后的玩家
        if (login.getScores()[0] == null) {
            login = this.chkLogin();
        }
        if (login != null) {
            int loginType = Menu.getPlayerUI();
            switch (loginType) {
                case 1:
                    // 开始游戏
                    // 定义游戏循环开关
                    boolean playFlag = true;
                    PlayGame pg = new PlayGame();
                    int index = 0;
                    while (playFlag) {
                        Bird[] birds = BirdHelper.ChooseBirds();
                        pg.setLogin(login);
                        pg.setBirds(birds);

                        // 获取时间
                        Calendar calendar = Calendar.getInstance();
                        Date date = calendar.getTime();
                        // 转换格式
                        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
                        String playTime = format.format(date);
                        int score = pg.play();
                        login.setScores(index, (score + ""));
                        login.setTimes(index, playTime);
                        System.out.println("是否继续游戏? [N 结束  其他   不结束]");
                        String s = InputHelper.getString();
                        if (s.equalsIgnoreCase("N")) {
                            playFlag = false;
                        } else {
                            index++;
                        }
                    }
                    ab.start(players, login);
                    // PlayerOP();
                    // Menu.getPlayerUI();
                case 2:
                    // 查看成绩
                    System.out.println("**********************************************");
                    System.out.println("当前玩家是:" + login.getName());
                    System.out.println("游戏时间\t\t\t\t游戏分数");

                    // 遍历分数数组和游戏时间数组
                    for (int i = 0, length = login.getScores().length; i < length; i++) {
                        // 除空
                        if (login.getTimes()[i] != null && login.getScores()[i] != null) {
                            System.out.print(login.getTimes()[i] + "\t\t" + login.getScores()[i]);
                        }
                        System.out.println();
                    }
                    ab.start(players, login);
                case 0:
                    // 返回上级
                    ab.start(players, login);
                    break;
                default:
                    break;
            }
        }
    }
}
