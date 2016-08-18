package com.lecheng.abgame.main;

import java.util.Calendar;
import java.util.Date;

import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.dao.DAO;
import com.lecheng.abgame.game.Bird;
import com.lecheng.abgame.game.PlayGame;
import com.lecheng.abgame.ui.Menu;
import com.lecheng.abgame.util.BirdHelper;
import com.lecheng.abgame.util.InputHelper;

public class PlayerManager {

    DAO dao = new DAO();
    AbGame ab = new AbGame();

    // 判断玩家是否登陆成功
    public Player chkLogin() {
        // 获取的是键盘输入的用户名和密码
        Player login = Menu.getLoginUI();
        String sql =
                "select id,name,pass,nickname nickName,sex,age from t_player where name = ? and pass = ?";
        Player player = dao.getForSingle(Player.class, sql, login.getId(), login.getPass());
        return player;
    }

    // 玩家登陆方法
    public void PlayerOP() {
        int loginType = 0;
        Player player = chkLogin();
        if (player != null) {
            System.out.println(player.getName() + " 已经登录成功！");
            loginType = Menu.getPlayerUI();
        } else {
            System.out.println("不存在此用户或密码不匹配，登录失败！");
        }
        switch (loginType) {
            case 1:
                // 开始游戏
                // 定义游戏循环开关
                boolean playFlag = true;
                PlayGame pg = new PlayGame();
                int index = 0;
                while (playFlag) {
                    Bird[] birds = BirdHelper.ChooseBirds();
                    Player login = chkLogin();
                    pg.setPlayer(login);
                    pg.setBirds(birds);
                    // 获取时间
                    Calendar calendar = Calendar.getInstance();
                    Date date = calendar.getTime();
                    // 转换格式
                    // SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    // String playTime = format.format(date);
                    // int score = pg.play();
                    // login.setScores(index, (score + ""));
                    // login.setTimes(index, playTime);
                    System.out.println("是否继续游戏? [N 结束  其他   不结束]");
                    String s = InputHelper.getString();
                    if (s.equalsIgnoreCase("N")) {
                        playFlag = false;
                    } else {
                        index++;
                    }
                }
                ab.start();
                // PlayerOP();
                // Menu.getPlayerUI();
            case 2:
                // 查看成绩
                // System.out.println("**********************************************");
                // System.out.println("当前玩家是:" + login.getName());
                // System.out.println("游戏时间\t\t\t\t游戏分数");
                //
                // // 遍历分数数组和游戏时间数组
                // for (int i = 0, length = login.getScores().length; i < length; i++) {
                // // 除空
                // if (login.getTimes()[i] != null && login.getScores()[i] != null) {
                // System.out.print(login.getTimes()[i] + "\t\t" + login.getScores()[i]);
                // }
                // System.out.println();
                // }
                // ab.start(players, login);
            case 0:
                // 返回上级
                ab.start();
                break;
            default:
                break;
        }
    }
}
