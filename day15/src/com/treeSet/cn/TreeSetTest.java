/**
 *
 */
package com.treeSet.cn;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author renjianyong
 *
 */
public class TreeSetTest {

    public static void main(String[] args) {

        Set set = new TreeSet();

        // set.add("AA");
        // set.add("MM");
        // set.add("LL");
        // set.add("OO");
        // set.add("GG");
        // set.add(90);
        // set.add("AA");
        set.add(new Person("AA", 23));
        set.add(new Person("KK", 23));
        set.add(new Person("LL", 23));
        set.add(new Person("YY", 23));
        set.add(new Person("CC", 23));
        set.add(new Person("SS", 23));
        System.out.println(set);
    }
}
