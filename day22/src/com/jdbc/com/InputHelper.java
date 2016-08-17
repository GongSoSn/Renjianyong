/**
 *
 */
package com.jdbc.com;

import java.util.Scanner;

/**
 * @author renjianyong
 *
 */
public class InputHelper {

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    public static int getInt() {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return s;
    }
}
