package com.lecheng.abgame.util;

import com.lecheng.abgame.bean.Player;

public class PlayerHelper {

    public static Player getPlayerData() {
        Player player = new Player();
        System.out.println("请输入新增玩家的用户名:");
        player.setName(checkUtil.checkName());
        System.out.println("请输入新增玩家的密码:");
        player.setPass(checkUtil.checkPass());
        System.out.println("请输入新增玩家的昵称:");
        player.setNickName(checkUtil.checkNickName());
        System.out.println("请输入新增玩家的性别:");
        player.setSex(checkUtil.checkSex());
        System.out.println("请输入年龄！");
        player.setAge(checkUtil.checkAge());
        return player;
    }
}
