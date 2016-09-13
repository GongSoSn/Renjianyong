/**
 *
 */
package com.BKesayGo.bean.cn;

import java.util.Date;

/**
 * @author Renjianyong
 *
 */
public class Sysuser {
    // create table tb_sysuser(
    // s_id int(11) not null primary key auto_increment,
    // s_username varchar(20),
    // s_truename varchar(30),
    // s_pwd varchar(20),
    // s_sex int(1),
    // s_birth date,
    // s_idcard varchar(25),
    // s_email varchar(30),
    // s_phone varchar(20),
    // s_address varchar(50),
    // s_if int(1),
    // create_man int(11),
    // create_time datetime,
    // update_man int(11),
    // update_time datetime
    // );
    private int s_id;
    private String s_username;
    private String s_truename;
    private String s_pwd;
    private int s_sex;
    private Date s_birth;
    private String s_idcard;
    private String s_email;
    private String s_phone;
    private String s_address;
    private int s_if;
    private int create_man;
    private Date create_time;
    private int update_man;
    private Date update_time;

    public Sysuser() {}

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_username() {
        return s_username;
    }

    public void setS_username(String s_username) {
        this.s_username = s_username;
    }

    public String getS_truename() {
        return s_truename;
    }

    public void setS_truename(String s_truename) {
        this.s_truename = s_truename;
    }

    public String getS_pwd() {
        return s_pwd;
    }

    public void setS_pwd(String s_pwd) {
        this.s_pwd = s_pwd;
    }

    public int getS_sex() {
        return s_sex;
    }

    public void setS_sex(int s_sex) {
        this.s_sex = s_sex;
    }

    public Date getS_birth() {
        return s_birth;
    }

    public void setS_birth(Date s_birth) {
        this.s_birth = s_birth;
    }

    public String getS_idcard() {
        return s_idcard;
    }

    public void setS_idcard(String s_idcard) {
        this.s_idcard = s_idcard;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public int getS_if() {
        return s_if;
    }

    public void setS_if(int s_if) {
        this.s_if = s_if;
    }

    public int getCreate_man() {
        return create_man;
    }

    public void setCreate_man(int create_man) {
        this.create_man = create_man;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_man() {
        return update_man;
    }

    public void setUpdate_man(int update_man) {
        this.update_man = update_man;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


}
