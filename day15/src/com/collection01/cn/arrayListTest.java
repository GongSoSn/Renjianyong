/**
 *
 */
package com.collection01.cn;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class arrayListTest {

    @Test
    public void addTest() {
        ArrayList list01 = new ArrayList();

        list01.add("Name");
        list01.add(23);
        list01.add(new Person());

        // 第一种遍历List集合的方法，使用迭代器
        Iterator iterator = list01.iterator();// 让集合返回一个迭代器

        // boolean next = iterator.hasNext();// hasNext()判断集合中是不是存在元素
        while (iterator.hasNext()) {
            System.out.println(iterator.next());// 返回集合中下一个迭代的元素
        }

        System.out.println("集合list01中的元素个数是: " + list01.size());

    }

}
