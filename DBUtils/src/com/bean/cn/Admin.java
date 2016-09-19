/**
 *
 */
package com.bean.cn;

/**
 * @author Renjianyong
 *
 */

public class Admin {
    @Override
    public String toString() {
        return "Admin [id=" + id + ", manager=" + manager + ", password=" + password + ", truename="
                + truename + "]";
    }

    // id int not null primary key,
    // nameger varchar(20) not null,
    // password varchar(20) not null,
    // truename varchar(20) not null
    private int id;
    private String manager;
    private String password;
    private String truename;

    public Admin() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }
}
