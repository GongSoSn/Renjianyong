/**
 *
 */
package com.lecheng.abgame.bean;

/**
 * javaBean实体类:用于存放登录游戏的信息
 *
 * @author renjianyong
 *
 */
public class Login extends Person {

    private String[] score = new String[10];

    public String[] getScore() {
        return score;
    }

    public void setScore(int index, String value) {
        this.score[index] = value;
    }



}
