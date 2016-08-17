package com.lecheng.abgame.bean;

public class Login extends Person {

    // 存放玩家比赛分数
    private String[] scores = new String[10];
    // 存放玩家的比赛时间
    private String[] times = new String[10];

    public String[] getScores() {
        return scores;
    }

    // 使用key/value的形式进行赋值和数组的移动
    public void setScores(int index, String value) {
        scores[index] = value;
    }

    public String[] getTimes() {
        return times;
    }

    public void setTimes(int index, String value) {
        times[index] = value;
    }
}
