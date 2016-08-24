/**
 *
 */
package com.lecheng.abgame.util;

/**
 * @author renjianyong
 *
 */
public class checkUtil {
    public static int checkAge() {
        boolean ageFlag = true;
        String checkAge = "";
        while (ageFlag) {
            // 判断年龄的范围

            checkAge = InputHelper.getInt() + "";
            if (checkAge.matches("[1][5-9]|[2][0-9]|(30)")) {
                ageFlag = false;
            } else {
                System.out.println("年龄不符合要求,请重新输入 ||格式[1][5-9]|[2][0-9]|(30)！！");
            }
        }
        return Integer.parseInt(checkAge);
    }

    // 验证用户名
    public static String checkName() {
        boolean nameFlag = true;
        String playerName = "";
        while (nameFlag) {

            playerName = InputHelper.getString();
            if (playerName.matches("[a-zA-Z]\\w{3,9}")) {
                nameFlag = false;
            } else {
                System.out.println("玩家姓名不符合要求，请重新输入||格式[a-zA-Z]\\w{5,9} !!!!");
            }
        }

        return playerName;
    }

    // 验证用户昵称
    public static String checkNickName() {
        boolean nickNameFlag = true;
        String checkNickName = "";
        while (nickNameFlag) {

            checkNickName = InputHelper.getString();
            if (checkNickName.matches("[\u4e00-\u9fa5\\w]{1,9}")) {
                nickNameFlag = false;
            } else {
                System.out.println("玩家昵称不符合要求，请重新输入 ||格式[\u4e00-\u9fa5\\w]{1,9}!!!!");
            }
        }

        return checkNickName;
    }

    // 验证密码
    public static String checkPass() {
        boolean passFlag = true;
        String checkPass = "";
        while (passFlag) {

            checkPass = InputHelper.getString();
            if (checkPass.matches("[\u4e00-\u9fa5\\w]{1,5}")) {
                passFlag = false;
            } else {
                System.out.println("玩家密码格式不符合要求，请重新输入 ||格式[\u4e00-\u9fa5\\w]{1,5}!!!!");
            }
        }

        return checkPass;
    }

    // 验证性别
    public static String checkSex() {
        boolean sexFlag = true;
        String checkSex = "";
        while (sexFlag) {

            checkSex = InputHelper.getString();
            if (checkSex.matches("['男''女']")) {
                sexFlag = false;
            } else {
                System.out.println("玩家性别不符合要求，请重新输入 ||格式['男''女']!!!!");
            }
        }

        return checkSex;
    }
}
