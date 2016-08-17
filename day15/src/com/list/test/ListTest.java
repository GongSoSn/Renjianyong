/**
 *
 */
package com.list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class ListTest {

    @Test
    public void listTest() {
        List list = new ArrayList();

        list.add("AA");
        list.add("KK");
        list.add("VV");
        list.add("SS");
        list.add("DD");

        System.out.println(list);
        list.add(3, "CC");
        System.out.println(list);
    }

    @Test
    public void test02() {
        List list = new ArrayList();

        list.add("AA");
        list.add("AA");
        list.add("VV");
        list.add("SS");
        list.add("DD");
        System.out.println(list);

        ListIterator listIterator = list.listIterator();

        // 正向遍历容器
        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (object.equals("SS")) {
                System.out.println("索引是：" + listIterator.nextIndex());
                listIterator.add("Helloppp");
            }
            System.out.print(object + " ");
        }
        listIterator.set("Final");
        System.out.println(list);
        // 逆向遍历容器
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}
