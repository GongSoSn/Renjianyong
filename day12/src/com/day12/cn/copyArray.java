/**
 *
 */
package com.day12.cn;

import java.util.Arrays;

/**
 * @author renjianyong
 *
 */
public class copyArray {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        int[] intCopy = new int[10];

        System.arraycopy(ints, 3, intCopy, 3, 3);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(intCopy));
    }
}
