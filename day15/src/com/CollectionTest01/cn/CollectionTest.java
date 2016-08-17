/**
 *
 */
package com.CollectionTest01.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;


/**
 * @author renjianyong
 *
 *         通过Collection接口的实现类ArrayList类演示Collection接口中的方法 || 使用多态
 */
public class CollectionTest {

    // Collection Method : add()確保容器中存在一個這樣的元素
    @Test
    public void testAdd() {

        Collection collection = new ArrayList();
        collection.add("Collection");
        collection.add(12);

        Iterator iterator = collection.iterator();
        // 使用for循环进行稽核元素的迭代处理
        for (; iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }

    // addAll()
    @Test
    public void testAddAll() {
        Collection coll = new ArrayList();
        Collection coll2 = new ArrayList();

        coll.add("集合1");
        coll2.add("集合2");
        coll2.addAll(coll);

        System.out.println(coll);
        System.out.println(coll2);

        Object obj[] = coll.toArray();
        for (Object object : obj) {
            System.out.print(object + " ");
        }

        System.out.println("Arrays.toString: ");
        Arrays.toString(obj);

        // 使用for处理iterator
        for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        System.out.println("*********************************************");
        // 使用while循环处理iterator
        Iterator iterator = coll2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Clear()
    @Test
    public void testClear() {
        Collection coll = new ArrayList();

        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");
        coll.add("FF");
        coll.add("GG");

        System.out.println(coll);

        coll.clear();
        System.out.println(coll);
    }

    // retainAll 只是保留這一部分元素
    @Test
    public void testRetainAll() {
        Collection collection = new ArrayList();
        Collection collection1 = new ArrayList();

        collection.add("AA");
        collection.add("DD");
        collection.add("XX");
        collection.add("CC");
        collection1.add("CC");
        collection.add("VV");
        collection1.add("VV");

        System.out.println(collection);
        System.out.println(collection1);

        collection.retainAll(collection1);
        System.out.println(collection);
    }

    // contains:容器中是否存在一個這樣的元素，如果存在，返回true
    @Test
    public void testContains() {
        // 新建一個容器
        Collection coll = new ArrayList();
        // 向容器中添加元素
        coll.add("AA");
        coll.add("SS");
        coll.add("FF");
        coll.add("VV");

        // 输出
        System.out.println(coll);
        // 判断
        boolean contains01 = coll.contains("AA");
        boolean contains02 = coll.contains("Aa");

        System.out.println(contains01);
        System.out.println(contains02);
    }

    // containsAll() : 判断容器中是不是包含另一个容器中的全部的元素
    @Test
    public void containsAllTest() {
        // 新建一个容器
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");

        System.out.println(coll);

        Collection coll2 = new ArrayList();
        coll2.add("BB");
        coll2.add("DD");
        coll2.add("EE");
        System.out.println(coll2);

        System.out.println(coll.containsAll(coll2));
    }

    // equals:比较两个集合是不是相同(里面的元素是不是相同，并且是集合的顺序是不是一一对应的相同)
    @Test
    public void equalsTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");

        Collection coll2 = new ArrayList();
        coll2.add("AA");
        coll2.add("CC");
        coll2.add("BB");
        coll2.add("DD");
        coll2.add("EE");
        System.out.println(coll);
        System.out.println(coll2);

        System.out.println(coll.equals(coll2));
    }

    // hashCode:这里的hashCode数值是计算每一个元素hashCode的和计算出来的一个数值
    @Test
    public void hashCodeTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");

        Collection coll2 = new ArrayList();
        coll2.add("AA");
        coll2.add("BB");
        coll2.add("CC");
        coll2.add("DD");
        coll2.add("EE");
        System.out.println(coll);
        System.out.println(coll.hashCode());
        System.out.println(coll2);
        System.out.println(coll2.hashCode());


        System.out.println(coll.equals(coll2));
    }

    // isEmpty:判断Collection是不是为空
    @Test
    public void isEmptyTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");
        Collection coll2 = new ArrayList();

        System.out.println(coll);
        System.out.println(coll2);

        System.out.println(coll.isEmpty());
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
        System.out.println(coll2.isEmpty());
    }

    // iterator:返回在集合元素上的迭代器
    @Test
    public void iteratorTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");
        System.out.println(coll);

        // 使用iterator遍历容器
        for (Iterator it = coll.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
    }

    // remove:移除容器中的指定元素，如果存在的话
    @Test
    public void removeTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");
        System.out.println(coll);

        coll.remove("BB");

        System.out.println(coll);
    }

    // removeAll:在容器中移除一部分元素
    @Test
    public void removeAllTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");
        System.out.println(coll);

        Collection coll2 = new ArrayList();
        coll2.add("AA");
        coll2.add("BB");
        coll2.add("CC");
        System.out.println(coll2);

        coll.removeAll(coll2);
        System.out.println(coll);
    }

    // toArray:将容器转换成数组
    @Test
    public void toArrayTest() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("EE");
        System.out.println(coll);

        Object[] objects = coll.toArray();

        for (Object object : objects) {
            System.out.print(object + " ");
        }
        // 使用Arrays数组工具类中的方法再将数组转换成集合
        Collection coll2 = Arrays.asList(objects);
        System.out.println(coll2);
    }
}
