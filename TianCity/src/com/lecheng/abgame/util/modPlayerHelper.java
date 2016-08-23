/**
 *
 */
package com.lecheng.abgame.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renjianyong
 *
 */
public class modPlayerHelper {

    // modPalyer
    @SuppressWarnings("rawtypes")
    public static List modPlayerBy(int id) {
        List<Object> target = new ArrayList<>();
        int i = 1;
        String sql = "update t_player set ";
        boolean bb = true;
        String name = null;
        String pass = null;
        String nickname = null;
        String sex = null;
        int age = 0;
        List<Object> list = new ArrayList<>();
        while (bb) {
            switch (i) {
                case 1:
                    System.out.println("是否修改姓名？ N [否] 其他 [是]");
                    String yes = InputHelper.getString();
                    if (yes.equalsIgnoreCase("N")) {
                        list.add(0, null);
                        i = 2;
                        continue;
                    } else {
                        System.out.println("请输入修改后的姓名：");
                        name = checkUtil.checkName();
                        sql += "name = ?";
                        list.add(0, name);
                    }
                case 2:
                    System.out.println("是否修改密码？  N [否] 其他 [是]");
                    String yes1 = InputHelper.getString();
                    if (yes1.equalsIgnoreCase("n")) {
                        list.add(1, null);
                        i = 3;
                        continue;
                    } else {
                        System.out.println("请输入修改后的密码：");
                        pass = checkUtil.checkPass();
                        if (list.get(0) != null) {
                            sql += ", pass = ?";
                        } else {
                            sql += "pass = ?";
                        }
                        list.add(1, pass);
                    }
                case 3:
                    System.out.println("是否修改昵称？  N [否] 其他 [是]");
                    String yes2 = InputHelper.getString();
                    if (yes2.equalsIgnoreCase("n")) {
                        list.add(2, null);
                        i = 4;
                        continue;
                    } else {
                        System.out.println("请输入修改后的昵称：");
                        nickname = checkUtil.checkNickName();
                        if (list.get(0) != null || list.get(1) != null) {
                            sql += ", nickname = ?";
                        } else {
                            sql += "nickname = ?";
                        }
                        list.add(2, nickname);
                    }
                case 4:
                    System.out.println("是否修改性别？  N [否] 其他 [是]");
                    String yes3 = InputHelper.getString();
                    if (yes3.equalsIgnoreCase("n")) {
                        list.add(3, null);
                        i = 5;
                        continue;
                    } else {
                        System.out.println("请输入修改后的性别：");
                        sex = checkUtil.checkSex();
                        if (list.get(0) != null || list.get(1) != null || list.get(2) != null) {
                            sql += " , sex = ?";
                        } else {
                            sql += "sex = ?";
                        }
                        list.add(3, sex);
                    }
                case 5:
                    System.out.println("是否修改年龄？  N [否] 其他 [是]");
                    String yes4 = InputHelper.getString();
                    if (yes4.equalsIgnoreCase("n")) {
                        list.add(4, null);
                        bb = false;
                        sql += ("where id = " + id);
                    } else {
                        System.out.println("请输入修改后的年龄：");
                        age = checkUtil.checkAge();
                        if (list.get(0) != null || list.get(1) != null || list.get(2) != null
                                || list.get(3) != null) {
                            sql += " , age = ?";
                        } else {
                            sql += "age = ?";
                        }
                        list.add(4, age);
                        bb = false;
                    }
            }

        }
        sql += " where id = " + id;
        target.add(0, sql);
        target.add(1, list);
        return target;
    }
}
