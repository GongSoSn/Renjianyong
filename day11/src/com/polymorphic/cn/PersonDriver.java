/**
 *
 */
package com.polymorphic.cn;

/**
 * @author renjianyong
 *
 */
public class PersonDriver {
    public static void main(String[] args) {
        Person person = new Allen();
        Person person2 = new Join();

        person.say();
        person2.say();
    }
}
