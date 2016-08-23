/**
 *
 */
package com.Proxy.test;

/**
 * @author renjianyong
 *
 */
public class ProxyCarFactory implements CarFactory {
    private CarFactory car;

    public ProxyCarFactory(CarFactory car) {
        this.car = car;
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
