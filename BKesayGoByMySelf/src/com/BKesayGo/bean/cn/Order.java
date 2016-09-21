/**
 *
 */
package com.BKesayGo.bean.cn;

import java.util.Date;

/**
 * @author Renjianyong
 *
 */
public class Order {
    /* 创建订单表tb_order */
    // constraint fk_ao foreign key(create_man) references admin(id)
    // );
    //
    // alter table tb_order add column create_time datetime;
    //
    // alter table tb_order modify o_id int(11) not null auto_increment;
    //
    // desc tb_order;
    private int o_id;
    private String o_truename;
    private String o_address;
    private Date o_money;
    private int o_time;
    private String o_if;
    private String o_user;
    private int create_man;
    // private Date create_time;
    private Admin admin;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_truename() {
        return o_truename;
    }

    public void setO_truename(String o_truename) {
        this.o_truename = o_truename;
    }

    public String getO_address() {
        return o_address;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }

    public Date getO_money() {
        return o_money;
    }

    public void setO_money(Date o_money) {
        this.o_money = o_money;
    }

    public int getO_time() {
        return o_time;
    }

    public void setO_time(int o_time) {
        this.o_time = o_time;
    }

    public String getO_if() {
        return o_if;
    }

    public void setO_if(String o_if) {
        this.o_if = o_if;
    }

    public String getO_user() {
        return o_user;
    }

    public void setO_user(String o_user) {
        this.o_user = o_user;
    }

    public int getCreate_man() {
        return create_man;
    }

    public void setCreate_man(int create_man) {
        this.create_man = create_man;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
