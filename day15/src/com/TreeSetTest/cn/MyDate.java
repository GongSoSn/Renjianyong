package com.TreeSetTest.cn;

/**
 * @author renjianyong
 *
 */
public class MyDate {
    // MyDate类包含:private成员变量month,day,year；
    // 并为每一个属性定义 getter, setter 方法；
    // 创建该类的 5 个对象，
    // 并把这些对象放入 TreeSet 集合中（下一章：
    // TreeSet 需使用泛型来定义
    private int month;
    private int day;

    /**
     * @param month
     * @param day
     * @param year
     */
    public MyDate(int month, int day, int year) {
        super();
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public MyDate() {}

    private int year;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "birthday[ " + year + "-" + month + "-" + day + " ]";
    }
}
