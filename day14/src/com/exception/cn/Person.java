/**
 *
 */
package com.exception.cn;

/**
 * @author renjianyong
 *
 */
public class Person {
    String name;

    void test() throws PersonException {
        if (name == null) {
            throw new PersonException("姓名不能为null... ...");
        }
    }
}
