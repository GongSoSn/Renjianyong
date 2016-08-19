package com.lecheng.abgame.main;

import java.util.List;

import com.lecheng.abgame.bean.Game;
import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.dao.DAO;
import com.lecheng.abgame.exception.PlayerNameSameException;
import com.lecheng.abgame.game.Bird;
import com.lecheng.abgame.game.BlackBird;
import com.lecheng.abgame.game.BlueBird;
import com.lecheng.abgame.game.DataInit;
import com.lecheng.abgame.game.RedBird;
import com.lecheng.abgame.ui.Menu;
import com.lecheng.abgame.util.InputHelper;
import com.lecheng.abgame.util.PlayerHelper;
import com.lecheng.abgame.util.XMLMod;

public class AdminManager {
    // 获取数据访问层对象
    DAO dao = new DAO();

    // 判断管理员是否登陆成功
    public boolean chkLogin() {
        // 创建初始化信息的对象
        DataInit init = new DataInit();
        Player login = Menu.getLoginUI();
        if (login.getName().equalsIgnoreCase(init.initAdmin().getName())
                && login.getPass().equalsIgnoreCase(init.initAdmin().getPass())) {
            return true;
        }
        return false;
    }

    // 管理员登陆 需要三次验证
    public boolean adminChkLogin() {
        // 创建初始化信息的对象
        DataInit init = new DataInit();
        boolean loop = false;
        for (int i = 1, times = init.initAdmin().getLoginTimes(); i <= times; i++) {
            loop = this.chkLogin();
            if (loop) {
                break;
            } else {
                if (times - i > 0) {
                    System.out.println("您的用户名密码输入有误，您还有" + (times - i) + "次机会。");
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
                    // System.out.println("新增玩家成功！");
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
            case 5:
                // 查询游戏
                Menu.getSearchGame();
                queryGame();
                this.adminOP();
                break;
            case 6:
                // 分数统计
                Menu.getScoreUI();
                getScoreShow();
                this.adminOP();
                break;
            case 7:// 参数操作
                this.modParas();
                this.adminOP();
                break;
            case 0:
                AbGame ab = new AbGame();
                ab.start();
                break;
            default:
                break;
        }
    }

    // 参数修改
    public void modParas() {
        int type = Menu.getModParas();

        switch (type) {
            case 1:// 修改RedBird
                XMLMod.modXML(this.modBirdParas(1));
                break;
            case 2:// 修改BlueBird
                XMLMod.modXML(this.modBirdParas(2));
                break;
            case 3:// 修改BlackBird
                XMLMod.modXML(this.modBirdParas(3));
                break;
            case 4:// 修改管理员名称
                System.out.println("正在修改管理员姓名... ...");
                XMLMod.XMLAdminMod(this.modAdmin(4).getName(), "Name");
                break;
            case 5:// 修改管理员密码
                System.out.println("正在修改管理员密码... ...");
                XMLMod.XMLAdminMod(this.modAdmin(5).getPass(), "Pass");
                break;
            case 6:// 修改管理员最大登录次数
                System.out.println("正在修改管理员登录最大次数... ...");
                XMLMod.XMLAdminMod(this.modAdmin(6).getLoginTimes(), "Times");
                break;
            case 0:// 返回上级
                break;
            default:
                System.out.println("没有此选项！");
                break;
        }
    }

    // 修改管理员信息
    public Login modAdmin(int type) {
        Login login = new Login();
        switch (type) {
            case 4:
                System.out.println("请输入修改后的管理员姓名:");
                login.setName(InputHelper.getString());
                break;
            case 5:
                System.out.println("请输入修改后的管理员密码:");
                login.setPass(InputHelper.getString());
                break;
            case 6:
                System.out.println("请输入修改后的管理员登录的最大次数:");
                login.setLoginTimes(InputHelper.getInt());
                break;
            default:
                System.out.println("不存在此操作 ！");
                break;
        }

        return login;
    }

    // 修改bird参数
    public Bird modBirdParas(int type) {
        Bird bird = null;
        switch (type) {
            case 1:// 修改RedBird
                bird = new RedBird();
                break;
            case 2:// 修改BlueBird
                bird = new BlueBird();
                break;
            case 3:// 修改BlackBird
                bird = new BlackBird();
                break;
            default:
                System.out.println("没有此类型小鸟 ！");
                break;
        }
        if (type == 1) {
            System.out.println("正在修改红色小鸟信息... ...");
        } else if (type == 2) {
            System.out.println("正在修改蓝色小鸟信息... ...");
        } else if (type == 3) {
            System.out.println("正在修改黑色小鸟信息... ...");
        }

        bird.setId(type);
        System.out.println("请输入需要修改后的小鸟名称:");
        bird.setBirdName(InputHelper.getString());
        System.out.println("请输入需要修改后的小鸟攻击力:");
        bird.setGJValue(InputHelper.getInt());
        System.out.println("请输入需要修改后的小鸟的命中率:");
        bird.setHitValue(InputHelper.getInt());
        return bird;
    }

    // 修改玩家
    public void modPlayer() {
        // 首先遍历一下玩家信息
        queryPlayer();
        // ①获取需要修改的玩家(通过匹配姓名找到需要修改的玩家)
        System.out.println("请您输入需要修改玩家的ID:");
        int modNo = InputHelper.getInt();
        // 判断是否存在此玩家
        String sql = "update t_player set name=?, pass=?,nickname = ?,sex = ?,age = ? where id = ?";
        Player player = PlayerHelper.getPlayerData();
        try {
            // 检查重名
            chkSameName(player);
            dao.update(sql, player.getName(), player.getPass(), player.getNickName(),
                    player.getSex(), player.getAge(), modNo);
            System.out.println("修改玩家成功！");
        } catch (PlayerNameSameException e) {
            System.out.println(
                    "错误代码：" + e.getErrCode() + "\n" + "错误信息：" + e.getErrMsg() + "\n" + "修改玩家失败！");
        }
    }

    // 删除玩家
    public void delePlayer() {
        // 首先遍历一下玩家信息
        queryPlayer();
        System.out.println("是否全部删除？ N [No] 其他 [YES]");
        String choose = InputHelper.getString();
        if (!choose.equalsIgnoreCase("N")) {
            String sql = "truncate table t_palyer";
            boolean b = dao.truncateData(sql);
            if (!b) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }

        } else {
            System.out.println("输入需要删除的玩家ID:");
            String deleName = InputHelper.getString();
            String sql = "delete from t_player where id = ?";
            int count = dao.update(sql, deleName);
            if (count > 0) {
                System.out.println("玩家删除成功！");
            } else {
                System.out.println("玩家删除失败！");
            }
        }
    }

    // 添加玩家
    public void addPlayer(Player player) {
        try {
            // 检查是否存在重名问题
            chkSameName(player);
            // SQL
            String addSQL = "insert into t_player values(null,?,?,?,?,?)";
            // 调用添加玩家方法
            dao.update(addSQL, player.getName(), player.getPass(), player.getNickName(),
                    player.getSex(), player.getAge());
            System.out.println("添加玩家成功！");
        } catch (PlayerNameSameException e) {
            System.out.println(
                    "错误代码：" + e.getErrCode() + "\n" + "错误信息：" + e.getErrMsg() + "\n" + "添加玩家失败！");
        }
    }

    // 检查玩家是否重名
    public void chkSameName(Player player) throws PlayerNameSameException {
        String sql = "select id,name,pass,nickname nickName,sex,age from t_player where name = ?";
        Player p = dao.getForSingle(Player.class, sql, player.getName());
        PlayerNameSameException.checkNameSame(p);
    }

    // 查询玩家方法
    public void queryPlayer() {
        String sql = "select id,name,pass,nickname nickName,sex,age from t_player";
        List<Player> players = dao.getForList(Player.class, sql, null);
        System.out.println("已经添加的玩家信息如下：\n玩家ID\t玩家姓名\t玩家昵称\t玩家性别\t玩家年龄");
        for (Player player : players) {
            // 去空
            if (player != null && player.getName().length() > 0) {
                System.out.println(player.getId() + "\t" + player.getName() + "\t"
                        + player.getNickName() + "\t" + player.getSex() + "\t" + player.getAge());
            }
        }
    }

    // 查询游戏
    public void queryGame() {
        List<Game> games = null;
        // 首先清空表中数据避免重复
        String clearSQL = "truncate table game";
        dao.truncateData(clearSQL);
        String sql =
                "insert into game(g_name,g_count,g_countscore,g_countavg,g_gno,g_index) select s.pname g_name,s.count g_count,s.sumscore g_countscore,s.s_avg g_countavg,g_no g_gno,t_index g_index from t_grade g,(select name pname,count(s_id) count,sum(s_score) sumscore,AVG(s_score) s_avg from t_player p,t_score s where id = s_id group by s_id) as s where s.s_avg between l_value and h_value";
        int count = dao.update(sql, null);
        if (count > 0) {
            String qureySQL = "select g_name gName,g_gno gNo,g_index gIndex from game";
            games = dao.getForList(Game.class, qureySQL, null);
            if (games.size() > 0) {
                for (int i = 0, len = games.size(); i < len; i++) {
                    System.out.print(games.get(i).getgName() + "\t" + games.get(i).getgCount()
                            + "\t" + games.get(i).getgNo() + "\t" + games.get(i).getgIndex()
                            + "\n");
                }
            }
        }
    }

    // 分数统计
    public void getScoreShow() {

        List<Game> games = null;
        // 首先清空表中数据避免重复
        String clearSQL = "truncate table game";
        dao.truncateData(clearSQL);
        String sql =
                "insert into game(g_name,g_count,g_countscore,g_countavg,g_gno,g_index) select s.pname g_name,s.count g_count,s.sumscore g_countscore,s.s_avg g_countavg,g_no g_gno,t_index g_index from t_grade g,(select name pname,count(s_id) count,sum(s_score) sumscore,AVG(s_score) s_avg from t_player p,t_score s where id = s_id group by s_id) as s where s.s_avg between l_value and h_value";
        int count = dao.update(sql, null);
        if (count > 0) {
            String qureySQL =
                    "select g_name gName,g_countscore gCountScore,g_countavg gCountAvg,g_gno gNo,g_index gIndex from game";
            games = dao.getForList(Game.class, qureySQL, null);
            if (games.size() > 0) {// 玩家姓名\t\t游戏总分\t\t平均分数\t\t攻击力等级\t\t游戏指数
                for (int i = 0, len = games.size(); i < len; i++) {
                    System.out.print(games.get(i).getgName() + "\t" + games.get(i).getgCountScore()
                            + "\t" + games.get(i).getgCountAvg() + "\t" + games.get(i).getgNo()
                            + "\t" + games.get(i).getgIndex() + "\n");
                }
            }
        }

    }
}
