/**
 *
 */
package com.lecheng.abgame.bean;

/**
 * 作为一个用户，玩家等的父类
 *
 * @author renjianyong
 *
 */
public class Person {
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", pass=" + pass + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
