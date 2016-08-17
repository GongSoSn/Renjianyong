/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public class Son extends Person {
    @Override
    public void b() {}

    public static void staticVariable(int n) {
        int a = n;
        final int b = 0;
        // static int v = 9;
        System.out.println(a);
    }

    public static void main(String[] args) {
        Son son = new Son();
        Son son1 = new Son();
        son.staticVariable(6);
        son1.staticVariable(99);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.test.cn.A#a()
     */
    @Override
    public void a() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see com.test.cn.C#c()
     */
    @Override
    public void c() {
        // TODO Auto-generated method stub

    }
}
