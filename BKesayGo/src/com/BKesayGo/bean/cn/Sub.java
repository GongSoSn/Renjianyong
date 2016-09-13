/**
 *
 */
package com.BKesayGo.bean.cn;

/**
 * @author Renjianyong
 *
 */
public class Sub {
    /* 创建小分类表tb_sub */
    // create table tb_sub(
    // s_id int(11) not null primary key,
    // s_name varchar(30) not null,
    // s_supid int(11) not null,
    // create_man int not null,
    // create_time datetime,
    // constraint fk_bp foreign key(s_supid) references tb_sup(s_supid),
    // constraint fk_ba foreign key(create_man) references admin(id)
    // );
    private int s_id;
    private String s_name;
    // private int s_supid;
    private Sup sup;
    // private int create_man;
    private Admin admin;

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Sup getSup() {
        return sup;
    }

    public void setSup(Sup sup) {
        this.sup = sup;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
