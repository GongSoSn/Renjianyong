/**
 *
 */
package com.lecheng.abgame.exception;

import com.lecheng.abgame.bean.Player;

/**
 * @author renjianyong
 *
 */
public class PlayerNameSameException extends Exception {

    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public PlayerNameSameException(int errCode, String errMsg) {
        // super(msg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public static void checkNameSame(String oldName, Player[] players)
            throws PlayerNameSameException {
        // 遍历玩家数组
        for (Player player : players) {
            // 验证是不是数组中存在这样的姓名
            if (player != null && oldName.equals(player.getName())) {
                throw new PlayerNameSameException(440, "玩家姓名冲突... ...");
            }
        }
    }
}
