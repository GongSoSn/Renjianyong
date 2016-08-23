package com.test.cn;

import org.junit.Test;

import com.Proxy.test.MyCar;
import com.Proxy.test.ProxyCarFactory;

public class DesignPatternTest {

    @Test
    public void proxyTest() {
        // 创建被代理类的对象
        MyCar myCar = new MyCar();
        // 创建代理类的对象
        ProxyCarFactory proxy = new ProxyCarFactory();
        // 执行方法
        proxy.productCar();
    }
}
