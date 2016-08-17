/**
 *
 */
package com.Proxy02.cn;

/**
 * @author renjianyong 静态代理
 */

interface Cloth {
    void clothPrduct();
}


// 被代理类
class NickProduct implements Cloth {

    @Override
    public void clothPrduct() {
        System.out.println("Nick product ... ...");
    }
}


// 代理类
class ClothProduct implements Cloth {

    // 声明被代理类的引用
    NickProduct clothProduct;

    public ClothProduct(NickProduct clothProduct) {
        this.clothProduct = clothProduct;
    }

    @Override
    public void clothPrduct() {
        System.out.println("代理类开始执行，收取代理费。");
        clothProduct.clothPrduct();
    }


}


public class YYYY {
    public static void main(String[] args) {
        NickProduct nn = new NickProduct();
    }
}

