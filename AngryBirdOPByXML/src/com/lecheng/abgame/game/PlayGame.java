package com.lecheng.abgame.game;

import java.util.Random;

import com.lecheng.abgame.bean.Login;

/**
 * 游戏类
 *
 * @author renjianyong
 *
 */
public class PlayGame {

    // 玩游戏时玩家的对象
    private Login login;
    // 玩游戏时小鸟数组
    private Bird[] birds = null;


    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Bird[] getBirds() {
        return birds;
    }

    public void setBirds(Bird[] birds) {
        this.birds = birds;
    }

    // 开始游戏
    public int play() {
        System.out.println();
        System.out
                .println("******************************模拟游戏画面**********************************");
        int sum = 0;
        for (int i = 0; i < birds.length; i++) {
            Bird bird = birds[i];
            if (bird != null) {
                System.out.println(bird.getBirdName() + "发起了第" + (i + 1) + "次攻击。");
                int a = this.chkAttack(bird);
                sum += a;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("本次游戏" + login.getName() + "总得分为:" + sum);
        System.out
                .println("******************************模拟游戏画面**********************************");
        return sum;
    }

    // 判断攻击是否命中
    public int chkAttack(Bird bird) {
        bird.display();
        bird.attack();
        Random r = new Random();
        int j = r.nextInt(10);
        int k = bird.getHitValue() / 10;
        if (k >= j) {
            System.out.println(bird.getBirdName() + "命中... ...");
            return bird.getGJValue();
        } else {
            System.out.println(bird.getBirdName() + "没有命中... ...");
            return 0;
        }
    }

}
