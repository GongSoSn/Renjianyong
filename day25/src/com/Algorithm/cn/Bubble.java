/**
 *
 */
package com.Algorithm.cn;

import java.util.Arrays;

/**
 * @author renjianyong 冒泡排序
 */
public class Bubble {

    public static void main(String[] args) {

        int[] ints = {23, 5, 23, 2, 3, 89, 54, 34, 76};
        System.out.println("排序之前：" + Arrays.toString(ints));
        for (int i = 0, len = ints.length; i < len; i++) {
            for (int j = 0, length = len - (i + 1); j < length; j++) {
                // 按照降序的方式排列
                if (ints[j] < ints[j + 1]) {
                    int temp = 0;
                    temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        System.out.println("排序之后：" + Arrays.toString(ints));
    }
}
