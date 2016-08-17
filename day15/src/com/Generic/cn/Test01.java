/**
 *
 */
package com.Generic.cn;

/**
 * @author renjianyong
 *
 */
public class Test01 {

    private String name;


    public <E> void add(E e) {
        System.out.println(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
