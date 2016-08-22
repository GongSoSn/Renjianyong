/**
 *
 */
package com.Algorithm.cn;

import java.util.Arrays;

/**
 * @author renjianyong
 *
 */
public class Choice {

    public static void main(String[] args) {

        int[] ints = {23, 5, 23, 2, 3, 89, 54, 34, 76};
        System.out.println("排序之前：" + Arrays.toString(ints));
        // 遍历数组元素
        for (int i = 0, len = ints.length; i < len; i++) {
            // 声明一个假设的最小值作为排序的开始
            int min = ints[i];
            // 跟踪并记录最小值数组元素的下标
            int index = i;
            for (int j = (index + 1); j < len; j++) {
                // 如果下一个元素比假定的最小值还小就交换位置重新修改最小值
                if (ints[j] < min) {
                    // 满足条件修改最小值并记录索引
                    min = ints[j];
                    index = j;
                }
            }
            // 交换位置：本次循环中的最小值放到本次循环开始的最小值位置
            ints[index] = ints[i];
            // 当前的最小值和本次循环开始的最小值进行交换
            ints[i] = min;
        }
        System.out.println("排序之后：" + Arrays.toString(ints));
    }
}
