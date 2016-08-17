/**
 *
 */
package com.TreeSetTest.cn;

import java.util.TreeSet;

/**
 * @author renjianyong
 *
 */
public class Employees {

    public static void main(String[] args) {

        // 创建TreeSet集合存放Employee对象
        TreeSet<Employee> emps = new TreeSet<Employee>();
        // 创建Employee对象
        Employee emp01 = new Employee("zhangsan", 6, new MyDate(12, 23, 2010));
        Employee emp02 = new Employee("lisi", 16, new MyDate(11, 15, 2000));
        Employee emp03 = new Employee("wangwu", 36, new MyDate(11, 3, 1980));
        Employee emp04 = new Employee("zhaoliu", 16, new MyDate(5, 13, 2000));
        Employee emp05 = new Employee("zhaosi", 26, new MyDate(7, 23, 1990));

        emps.add(emp01);
        emps.add(emp02);
        emps.add(emp03);
        emps.add(emp04);
        emps.add(emp05);

        // 输出emps
        // System.out.println(emps);

        // 遍历
        for (Employee e : emps) {
            System.out.println(e);
        }
    }
}
