/**
 *
 */
package com.TreeSetTest.cn;

/**
 * @author renjianyong
 *
 */
public class Employee implements Comparable {
    // 定义一个Employee类，该类包含：private成员变量name,age,birthday，其中 birthday,为 MyDate 类的对象；
    // 并为每一个属性定义 getter, setter 方法；并重写 toString方法,输出 name, age, birthday
    private String name;
    private int age;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param name
     * @param age
     * @param birthday
     */
    public Employee(String name, int age, MyDate birthday) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name:" + name + ", age:" + age + ", " + birthday;
    }

    // 按照name属性进行排序
    @Override
    public int compareTo(Object o) {
        // 判断是不是Employee类型的对象，如果是转型
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
        return 0;
    }

}
