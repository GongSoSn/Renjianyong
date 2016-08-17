/**
 *
 */
package com.collection01.cn;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author renjianyong
 *
 */
public class TestSize {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add("James");
        list.add(23);
        list.add(new Person());

        // 获取一个iterator
        Iterator iterator = list.iterator();
        // 是否存在一个元素
        boolean hasNext = iterator.hasNext();// 会出现NoSuchElementsException:
        /*
         * 因为在line 25已经进行了一次判断,所以在判断是不是还有下一个元素的时候是忽略第一个的，等剩下的都判断结束之后，该方法(hasNext())发现还有一个元素
         * 即：第一个元素，所以，该方法的返回值是true，但是next()方法的指针已经指向了最后一个元素，并且这是单向的，故就造成了“该机制判断还有元素
         * 但是，无法遍历的原因，所以就会报‘NoSuchException’异常”
         */
        // 遍历
        while (hasNext) {
            System.out.println("iterator");
            System.out.println(iterator.next());
        }
    }
}
