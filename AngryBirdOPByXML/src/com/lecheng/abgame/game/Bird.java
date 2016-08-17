package com.lecheng.abgame.game;

/**
 * @author renjianyong
 *
 */
public abstract class Bird {
    // 小鸟的编号
    private int id;
    // 小鸟的名称
    private String BirdName;
    // 小鸟的攻击力
    private int GJValue;
    // 小鸟的命中率
    private int hitValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirdName() {
        return BirdName;
    }

    public void setBirdName(String birdName) {
        BirdName = birdName;
    }

    public int getGJValue() {
        return GJValue;
    }

    public void setGJValue(int gJValue) {
        GJValue = gJValue;
    }

    public int getHitValue() {
        return hitValue;
    }

    public void setHitValue(int hitValue) {
        this.hitValue = hitValue;
    }

    // 描述小鸟
    public abstract void display();

    // 小鸟开始攻击
    public abstract void attack();
}
