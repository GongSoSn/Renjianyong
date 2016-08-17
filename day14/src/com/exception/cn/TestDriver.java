/**
 *
 */
package com.exception.cn;

/**
 * @author renjianyong
 *
 */
public class TestDriver {
    public static void main(String[] args) {
        Person person = new Person();
        // person.name = "AAAA";
        try {
            person.test();
            System.out.println("输出姓名");
            System.out.println(person.name);
        } catch (PersonException e) {
            e.printStackTrace();
            System.out.println("捕获异常... ...");
        }
    }
}
