/**
 *
 */
package com.lecheng.abgame.bean;

/**
 * @author renjianyong
 *
 */
public class Game {
    private String gName;
    private int gCount;
    private int gCountScore;
    private double gCountAvg;
    private int gNo;
    private String gIndex;

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgCount() {
        return gCount;
    }

    public void setgCount(int gCount) {
        this.gCount = gCount;
    }

    public int getgCountScore() {
        return gCountScore;
    }

    public void setgCountScore(int gCountScore) {
        this.gCountScore = gCountScore;
    }

    public double getgCountAvg() {
        return gCountAvg;
    }

    public void setgCountAvg(double gCountAvg) {
        this.gCountAvg = gCountAvg;
    }

    public int getgNo() {
        return gNo;
    }

    public void setgNo(int gNo) {
        this.gNo = gNo;
    }

    public String getgIndex() {
        return gIndex;
    }

    public void setgIndex(String gIndex) {
        this.gIndex = gIndex;
    }

    @Override
    public String toString() {
        return "Game [gName=" + gName + ", gCount=" + gCount + ", gCountScore=" + gCountScore
                + ", gCountAvg=" + gCountAvg + ", gNo=" + gNo + ", gIndex=" + gIndex + "]";
    }

}
