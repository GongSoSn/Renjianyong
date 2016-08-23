package com.lecheng.abgame.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lecheng.abgame.bean.Bird;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.bean.Score;
import com.lecheng.abgame.dao.DAO;
import com.lecheng.abgame.game.PlayGame;
import com.lecheng.abgame.ui.Menu;
import com.lecheng.abgame.util.BirdHelper;
import com.lecheng.abgame.util.InputHelper;
import com.lecheng.abgame.util.SQLHelper;

public class PlayerManager {

    DAO dao = new DAO();
    AbGame ab = new AbGame();

    // 判断玩家是否登陆成功
    public Player chkLogin() {
        // 获取的是键盘输入的用户名和密码
        Player login = Menu.getLoginUI();
        String sql = SQLHelper.getSQL("checkPlayer");
        Player player = dao.getForSingle(Player.class, sql, login.getName(), login.getPass());
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
        boolean loop = true;
        while (loop) {
            switch (loginType) {
                case 1:
                    // 开始游戏
                    // 定义游戏循环开关
                    boolean playFlag = true;
                    PlayGame pg = new PlayGame();
                    while (playFlag) {
                        Bird[] birds = BirdHelper.ChooseBirds();
                        pg.setPlayer(player);
                        pg.setBirds(birds);
                        // 获取时间
                        Calendar calendar = Calendar.getInstance();
                        Date date = calendar.getTime();
                        // 转换格式
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String playTime = format.format(date);
                        int score = pg.play();
                        String sql = SQLHelper.getSQL("insertScore");
                        // 调用update方法将游戏结果存放在数据库
                        dao.update(sql, player.getId(), score, playTime);
                        System.out.println("是否继续游戏? [N 结束  其他   不结束]");
                        String s = InputHelper.getString();
                        if (s.equalsIgnoreCase("N")) {
                            playFlag = false;
                        }

                    }
                    loginType = Menu.getPlayerUI();
                    break;
                case 2:
                    // 查看成绩
                    System.out.println("**********************************************");
                    System.out.println("当前玩家是:" + player.getName());
                    System.out.println("\t游戏时间\t\t\t游戏分数");
                    String sql = SQLHelper.getSQL("queryScore");
                    List<Score> list = dao.getForList(Score.class, sql, player.getId());
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.print(
                                    " " + list.get(i).getTime() + "\t\t" + list.get(i).getScore());
                            System.out.println();
                        }
                    }
                    System.out.println("\n\n");
                    loginType = Menu.getPlayerUI();
                    break;
                case 0:
                    // 返回上级
                    ab.start();
                    break;
                default:
                    break;

            }
        }
    }
}
