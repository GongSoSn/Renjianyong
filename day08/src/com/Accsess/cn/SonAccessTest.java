package com.Accsess.cn;

public class SonAccessTest extends AccessTest {
    public static void main(String[] args) {
        new SonAccessTest().name = "";// 此时的‘name’属性是继承自‘AccessTest类’，同一个包中的所有子类是能访问的(protected)
        new SonAccessTest().age = "";// 同一个包中的子类能够访问(default)
    }
}
