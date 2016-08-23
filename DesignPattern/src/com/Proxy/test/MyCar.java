/**
 *
 */
package com.Proxy.test;

/**
 * @author renjianyong
 *
 */
public class MyCar implements CarFactory {

    @Override
    public void productCar() {
        System.out.println("我自己公司生产的汽车！");
    }

}
