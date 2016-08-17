/**
 *
 */
package com.MapTest.cn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class MapTest {
    @Test
    public void test01() {

        Map map = new HashMap();

        map.put("01", "AA");
        map.put("02", "AA");
        map.put("03", "AA");
        map.put("05", "AA");
        map.put("04", "AA");

        System.out.println(map);
        // 遍历
        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        // 第二种遍历方法
        System.out.println("******************************************");
        Set keySet = map.keySet();
        for (Object object : keySet) {
            System.out.println(object);
        }
        System.out.println("******************************************");
        System.out.println("******************************************");
        for (Object object : keySet) {
            System.out.println(object + "---->" + map.get(object));
        }
        // 第三种遍历方式
        System.out.println("******************************************");
        Collection collection = map.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
