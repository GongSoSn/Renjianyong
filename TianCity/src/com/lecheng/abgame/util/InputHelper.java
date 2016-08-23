package com.lecheng.abgame.util;

import java.util.Scanner;

/**
 * @author renjianyong
 *
 */
public class InputHelper {


    // 获取控制台上的键盘输入 返回String类型
    public static String getString() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    // 获取控制台上的键盘输入 返回int类型
    public static int getInt() {
        try {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("格式输入错误,请您重新输入！！！");
        }
        return

        getInt();
    }
}
