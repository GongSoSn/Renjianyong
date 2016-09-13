/**
 *
 */
package com.BKesayGo.bean.cn;

import java.util.Date;

/**
 * @author Renjianyong
 *
 */
public class Goods {
    /* 创建商品表tb_goods */
    // g_name varchar(50) not null,
    // g_price decimal(10,4) not null,
    // g_subid int(11) not null,
    // g_supid int(11) not null,
    // g_number int,
    // g_bigpic varchar(50),
    // g_introduce varchar(100),
    // g_iftop varchar(10),
    // create_man int(11) not null,
    // create_time datetime,
    // constraint fk_ga foreign key(create_man) references admin(id),
    // constraint fk_gb foreign key(g_subid) references tb_sub(s_id),
    // constraint fk_gp foreign key(g_supid) references tb_sup(s_supid)
    // );

    private int g_id;
    private String g_name;
    private double g_price;
    // private int g_subid;
    private Sub sub;
    // private int g_supid;
    private Sup sup;
    private int g_number;
    private String g_bigpic;
    private String g_introduce;
    private String g_iftop;
    // private int create_man;
    private Admin admin;
    private Date create_time;

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public Sub getSub() {
        return sub;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    public Sup getSup() {
        return sup;
    }

    public void setSup(Sup sup) {
        this.sup = sup;
    }

    public int getG_number() {
        return g_number;
    }

    public void setG_number(int g_number) {
        this.g_number = g_number;
    }

    public String getG_bigpic() {
        return g_bigpic;
    }

    public void setG_bigpic(String g_bigpic) {
        this.g_bigpic = g_bigpic;
    }

    public String getG_introduce() {
        return g_introduce;
    }

    public void setG_introduce(String g_introduce) {
        this.g_introduce = g_introduce;
    }

    public String getG_iftop() {
        return g_iftop;
    }

    public void setG_iftop(String g_iftop) {
        this.g_iftop = g_iftop;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

}
