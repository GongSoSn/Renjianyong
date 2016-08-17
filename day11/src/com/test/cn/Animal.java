/**
 *
 */
package com.test.cn;

/**
 * @author renjianyong
 *
 */
public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param name
     */
    public Animal(String name) {
        this.name = name;
    }

}
