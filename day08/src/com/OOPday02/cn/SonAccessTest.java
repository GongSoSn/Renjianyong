package com.OOPday02.cn;

import com.Accsess.cn.AccessTest;

public class SonAccessTest extends AccessTest {
    public static void main(String[] args) {
        new SonAccessTest().name = "";// 说明：不同包下的所有子类也是能够访问的(protected)
        // new SonAccessTest().age = "";// 说明：不同包中的所有子类是不能访问的(default)
    }
}
