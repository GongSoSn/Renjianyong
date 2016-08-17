/**
 *
 */
package com.lecheng.abgame.bean;

/**
 * 实体类:用于存放玩家信息
 *
 * @author renjianyong
 *
 */
public class Player extends Person {
    private String nickName;
    private String sex;
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

}
