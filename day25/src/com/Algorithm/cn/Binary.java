/**
 *
 */
package com.Algorithm.cn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author renjianyong
 *
 */
public class Binary {
    /*
     * 非递归二分查找算法 参数:整型数组,需要比较的数.
     */
    public static int binarySearch(Integer[] srcArray, int des) {
        // 第一个位置.
        int low = 0;
        // 最高位置.数组长度-1,因为下标是从0开始的.
        int high = srcArray.length - 1;
        // 当low"指针"和high不重复的时候.
        while (low <= high) {
            // 中间位置计算,low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
            int middle = low + ((high - low) >> 1);
            // 与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.
            if (des == srcArray[middle]) {
                return middle;
                // 如果小于的话则移动最高层的"指针"
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                // 移动最低的"指针"
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Integer[] ints = {2, 5, 7, 9, 3, 6, 34, 89, 234};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        Scanner s = new Scanner(System.in);
        System.out.println("请输入需要查找的数字：");
        int target = s.nextInt();
        int b = binarySearch(ints, target);
        System.out.println(b);
    }
}
