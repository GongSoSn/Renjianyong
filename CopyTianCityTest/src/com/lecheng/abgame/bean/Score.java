package com.lecheng.abgame.bean;

import java.util.Date;

public class Score {
    private int id;
    private int score;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Score [id=" + id + ", score=" + score + ", time=" + time + "]";
    }
}
