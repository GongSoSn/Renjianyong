/**
 *
 */
package com.day12.cn;

/**
 * @author renjianyong
 *
 */
public class StringTest {
    public static void main(String[] args) {
        String a = new String("N");
        String b = new String("N");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("user.name"));
    }
}
