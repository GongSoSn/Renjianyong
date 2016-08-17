/**
 *
 */
package com.day12.cn;

/**
 * @author renjianyong
 *
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("无参数的构造器！！！");
    }

    public Person(String n) {
        name = n;
    }

    public Person(int a) {
        this("Join");
        age = a;
    }

    private static String sex = "Man";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        // Person person = new Person(23);
        // String name = person.getName();
        // System.out.println(name);
        System.out.println(sex);
    }
}
