package com.Accsess.cn;

public class AccessTest02 {
    public static void main(String[] args) {
        AccessTest at = new AccessTest();
        at.name = "";// 同一个包中不同类能够访问
        at.age = "";// 同一个包中不同类能够访问
    }
}
