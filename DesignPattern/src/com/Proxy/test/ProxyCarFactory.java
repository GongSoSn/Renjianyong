/**
 *
 */
package com.Proxy.test;

/**
 * @author renjianyong
 *
 */
public class ProxyCarFactory implements CarFactory {
    private MyCar car;

    // 第一种方式初始化
    // public ProxyCarFactory(CarFactory car) {
    // this.car = car;
    // }

    // 第二种方法初始化
    public ProxyCarFactory() {
        this.car = new MyCar();
    }

    @Override
    public void productCar() {
        this.proxyPrice();
        car.productCar();
        this.showCarType();
    }

    public void proxyPrice() {
        System.out.println("开始收取代理费 23 $.");
    }

    public void showCarType() {
        System.out.println("车型！");
    }
}
