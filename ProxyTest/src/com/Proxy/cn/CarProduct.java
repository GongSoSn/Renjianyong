/**
 *
 */
package com.Proxy.cn;

/**
 * @author renjianyong
 *
 */

interface CarFactory {
    void productCar();
}


class BMWFactory implements CarFactory {
    @Override
    public void productCar() {
        System.out.println("宝马车生成公司！");
    }

}


class ProxyCar implements CarFactory {

    BMWFactory bmw;

    public ProxyCar(BMWFactory bmw) {
        this.bmw = bmw;
    }


    @Override
    public void productCar() {
        System.out.println("我是代理车厂家，收取代理费用 $ 1000");
        bmw.productCar();
    }

}


public class CarProduct {

    public static void main(String[] args) {
        BMWFactory bmw = new BMWFactory();
        ProxyCar proxy = new ProxyCar(bmw);
        proxy.productCar();
    }



}
