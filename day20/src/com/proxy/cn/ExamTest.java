/**
 *
 */
package com.proxy.cn;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class ExamTest {

    @Test
    public void test01() {

        for (int i = 1; i <= 150; i++) {

            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
                System.out.println(i + " A　B C");
                continue;
            }

            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " A B");
                continue;
            }

            if (i % 3 == 0) {
                System.out.println(i + " A");
            }
        }
    }

    @Test
    public void test02() {}
}
