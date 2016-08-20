package com.lecheng.abgame.bean;

/**
 * 玩家信息的封装类
 *
 * @author renjianyong
 *
 */
public class Player extends Person {
    // 封装玩家的昵称
    private String nickName;
    // 封装玩家的性别
    private String sex;
    // 封装玩家的年龄
    private int age;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player [nickName=" + nickName + ", sex=" + sex + ", age=" + age + "]";
    }
}
