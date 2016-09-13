/**
 *
 */
package com.BKesayGo.bean.cn;

import java.util.Date;

/**
 * @author Renjianyong
 *
 */
public class Bulletin {
    /* 创建公告表tb_bulletin */
    // create_man int(11) not null,
    // constraint fk_ab foreign key (create_man) references admin(id)
    // );
    // alter table tb_bulletin add column update_man int(11);
    // alter table tb_bulletin add column update_time datetime;
    // alter table tb_bulletin modify b_id int(11) not null auto_increment;
    //
    // desc tb_bulletin;

    private int b_id;
    private String b_title;
    private String b_inner;
    private Date create_time;
    private int create_man;
    private int update_man;
    private Date update_time;

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getB_inner() {
        return b_inner;
    }

    public void setB_inner(String b_inner) {
        this.b_inner = b_inner;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getCreate_man() {
        return create_man;
    }

    public void setCreate_man(int create_man) {
        this.create_man = create_man;
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
