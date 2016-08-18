/**
 *
 */
package com.Proxy.cn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author renjianyong
 *
 */

interface SubObj {
    void doSome();
}


class RealObj implements SubObj {

    @Override
    public void doSome() {
        System.out.println("真正的执行者！");
    }

}


class MyInvocationHandler implements InvocationHandler {
    // 声明实现了接口的被代理类
    Object obj;

    public Object returnProxy(Object obj) {
        this.obj = obj;
        // 返回代理类
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object returnVal = method.invoke(obj, args);

        return returnVal;
    }

}


public class DynamicProxy {

    public static void main(String[] args) {
        // 实例化被代理类的对象
        RealObj real = new RealObj();
        MyInvocationHandler handler = new MyInvocationHandler();
        Object obj = handler.returnProxy(real);
        SubObj object = (SubObj) obj;
        object.doSome();

        BMWFactory bmw = new BMWFactory();

        Object realBmw = handler.returnProxy(bmw);

        CarFactory sub = (CarFactory) realBmw;

        sub.productCar();
    }

}
