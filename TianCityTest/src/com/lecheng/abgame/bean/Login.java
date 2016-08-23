package com.lecheng.abgame.bean;

public class Login extends Person {


    // 存放管理员最大登录次数
    private int loginTimes;

    public int getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(int loginTimes) {
        this.loginTimes = loginTimes;
    }

}
