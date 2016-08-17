/**
 *
 */
package com.ReflectionTest.cn;

/**
 * @author renjianyong
 *
 */
public class Person {

    private int id;

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

    private String name;
    public int age;
    public String gender;

    public void say(String n) {
        System.out.println(n);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
