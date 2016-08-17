/**
 *
 */
package com.day14.cn;

/**
 * @author renjianyong
 *
 */
public class ExceptionTest {
    String name = "pppp";

    public void test() {
        System.out.println(this.name);
        this.test1();
    }

    public void test1() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        // static int a = 9;
        // this.test();
        ExceptionTest test = new ExceptionTest();
        test.test();
    }
}
