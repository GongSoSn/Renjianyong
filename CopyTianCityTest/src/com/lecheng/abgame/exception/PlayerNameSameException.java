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

    public static void checkNameSame(Player p) throws PlayerNameSameException {
        boolean flag = true;
        if (p != null) {
            flag = false;
            throw new PlayerNameSameException(440, "玩家姓名冲突... ...");
        }

    }
}
