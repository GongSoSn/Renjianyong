/**
 *
 */
package com.treeSet.cn;

/**
 * @author renjianyong
 *
 */
public class Person implements Comparable {

    private String name;
    private int age;

    /**
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {}

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

    @Override
    public int compareTo(Object o) {
        // 自定义比较的标准
        int i = 0;
        if (o instanceof Person) {
            Person p = (Person) o;
            i = this.age - p.age;
            if (i == 0) {
                return this.name.compareTo(p.name);
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "Name : " + name + " , Age : " + age;
    }
}
