package com.lecheng.abgame.util;

import com.lecheng.abgame.bean.Player;

public class PlayerHelper {

    public static Player getPlayerData() {
        Player player = new Player();

        player.setName(checkUtil.checkName());
        player.setPass(checkUtil.checkPass());
        player.setNickName(checkUtil.checkNickName());
        player.setSex(checkUtil.checkSex());
        player.setAge(checkUtil.checkAge());
        return player;
    }
}
