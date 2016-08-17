/**
 *
 */
package com.Proxy02.cn;

/**
 * @author renjianyong
 *
 */
public class DirverTest {

    public static void main(String[] args) {
        // 实例化一个被代理类的对象
        RealObject real = new RealObject();
        // MyInvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler();

        Object obj = handler.getObj(real);

        SubObject sub = (SubObject) obj;

        sub.show();
        real.show();
        NickProduct nn = new NickProduct();

        Object oo = handler.getObj(nn);
        Cloth cc = nn;

        cc.clothPrduct();
        nn.clothPrduct();
    }

}
