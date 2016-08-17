/**
 *
 */
package com.lecheng.abgame.game;

import java.util.Random;

import com.lecheng.abgame.bean.Login;

/**
 * @author renjianyong
 *
 */
public class PlayGame {

    private Login login;
    private Bird[] birds;

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

    Random random = new Random();
    int atk = random.nextInt(10);

    public int playStart() {
        int sum = 0;
        System.err.println("********************************游戏开始***************************");

        for (int i = 0, length = birds.length; i < length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(birds[i].getBirdName() + "开始了第" + (i + 1) + "次攻击 ！");
            // 判断是否命中
            sum += chkHit(birds[i]);
        }
        System.err.println("本次游戏得分:" + sum);
        System.err.println("********************************游戏结束***************************");
        return sum;
    }

    public int chkHit(Bird bird) {
        bird.display();
        bird.attack();
        if ((bird.getAtkValue() / 10) >= atk) {
            System.err.println("命中... ...");
            return bird.getHitValue();
        } else {
            System.err.println("没有命中... ...");
        }
        return 0;

    }
}
