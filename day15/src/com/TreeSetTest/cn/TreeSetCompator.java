/**
 *
 */
package com.TreeSetTest.cn;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author renjianyong
 *
 */
public class TreeSetCompator {

    public static void main(String[] args) {

        // 创建TreeSet集合存放Employee对象
        TreeSet<Employee> emps = new TreeSet<Employee>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int num = 0;
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee emp01 = (Employee) o1;
                    Employee emp02 = (Employee) o2;
                    // 按照出生年月进行排序
                    if (emp01.getBirthday().getYear() == emp02.getBirthday().getYear()) {

                        num = emp01.getBirthday().getMonth() - emp02.getBirthday().getMonth();

                        if (emp01.getBirthday().getMonth() == emp02.getBirthday().getMonth()) {

                            num = emp01.getBirthday().getDay() - emp02.getBirthday().getDay();

                        }
                        return num;
                    }

                    num = emp01.getBirthday().getYear() - emp02.getBirthday().getYear();
                }
                return num;
            }
        });
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

        // 遍历
        for (Employee e : emps) {
            System.out.println(e);
        }
    }
}
