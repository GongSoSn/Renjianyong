/**
 *
 */
package com.polymorphic.cn;

/**
 * @author renjianyong
 *
 */
public class Join extends Person {
    private String name;

    @Override
    public void say() {
        System.out.println("Join Say()");
    }

    @Override
    public void look() {
        System.out.println("Join look()");
    }
}
