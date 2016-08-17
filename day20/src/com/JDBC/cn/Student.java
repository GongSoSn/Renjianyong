/**
 *
 */
package com.JDBC.cn;

/**
 * @author renjianyong
 *
 */
public class Student {

    private int st_id;
    private String st_name;
    private int st_age;

    public Student() {

    }

    public Student(int id, String name, int age) {
        st_id = id;
        st_name = name;
        st_age = age;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public int getSt_age() {
        return st_age;
    }

    public void setSt_age(int st_age) {
        this.st_age = st_age;
    }

    @Override
    public String toString() {
        return "Student [st_id=" + st_id + ", st_name=" + st_name + ", st_age=" + st_age + "]";
    }


}
