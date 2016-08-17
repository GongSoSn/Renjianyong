/**
 *
 */
package com.lecheng.abgame.util;

import java.util.Scanner;

/**
 * 提供I/O输入帮助类
 *
 * @author renjianyong
 *
 */
public class InputHelper {
    // Scanner scanner;

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
