/**
 *
 */
package com.genericTest.cn;

/**
 * @author renjianyong
 *
 */
public class User {
    // 定义一个 User 类： 该类包含：private成员变量（int类型） id，age；（String 类型）name。
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    /**
     * @param id
     * @param age
     * @param name
     */
    public User(int id, int age, String name) {
        super();
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", age=" + age + ", name=" + name + "]";
    }

}
