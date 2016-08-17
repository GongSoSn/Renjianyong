/**
 *
 */
package com.lecheng.abgame.game;

/**
 * @author renjianyong
 *
 */
public abstract class Bird {

    // 小鸟ID
    private int ID;
    // 小鸟名称
    private String birdName;
    // 小鸟攻击力
    private int atkValue;
    // 小鸟命中率
    private int hitValue;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public int getAtkValue() {
        return atkValue;
    }

    public void setAtkValue(int atkValue) {
        this.atkValue = atkValue;
    }

    public int getHitValue() {
        return hitValue;
    }

    public void setHitValue(int hitValue) {
        this.hitValue = hitValue;
    }

    // 小鸟描述信息
    public abstract void display();

    // 小鸟攻击描述
    public abstract void attack();
}
