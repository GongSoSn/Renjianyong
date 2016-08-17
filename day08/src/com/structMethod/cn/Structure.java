package com.structMethod.cn;

public class Structure {
    private String name;
    private int age;

    public Structure() {

    }

    public Structure(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[ " + name + "," + age + " ]";
    }
}
