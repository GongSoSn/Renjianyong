/**
 *
 */
package com.CollectionsTest.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class CollectionsTest {

    @Test
    public void test01() {
        List list = new ArrayList();

        list.add(12);
        list.add(10);
        list.add(2);
        list.add(22);
        list.add(3);
        list.add(92);

        // list.add("AA");
        // list.add("VV");
        // list.add("BB");
        // list.add("DD");
        // list.add("WW");
        // list.add("CC");

        System.out.println(list);

        // 找到容器中的最大值和最小值
        int max = Collections.max(list);
        System.out.println(max);
        int min = Collections.min(list);
        System.out.println(min);

        // 进行元素的反转
        Collections.reverse(list);
        System.out.println(list);
        // 交换指定位置的元素
        Collections.swap(list, 0, 1);
        System.out.println(list);
        // 根据元素的自然顺序进行排序
        Collections.sort(list);
        System.out.println(list);
    }
}
