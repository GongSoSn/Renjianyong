/**
 *
 */
package com.Calender.cn;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author renjianyong
 *
 */
public class CalenderTest {
    public static void main(String[] args) {
        CalenderTest test = new CalenderTest();
        test.test();
    }

    public void test() {
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        System.out.println(year + "-" + month + "-" + day);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = format.format(cal.getTime());
        System.out.println(date);
    }
}
