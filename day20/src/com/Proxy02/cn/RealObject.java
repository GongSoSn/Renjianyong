/**
 *
 */
package com.Proxy02.cn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author renjianyong 动态代理
 */

interface SubObject {
    void show();
}


// 被代理类
public class RealObject implements SubObject {

    @Override
    public void show() {
        System.out.println("我是真正的执行者");
    }

}


class MyInvocationHandler implements InvocationHandler {
    // 声明被代理类的一个引用
    Object obj;

    //
    public Object getObj(Object obj) {
        this.obj = obj;
        // 返回代理类对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object objValue = method.invoke(obj, args);
        System.out.println(objValue);
        return objValue;
    }


}


