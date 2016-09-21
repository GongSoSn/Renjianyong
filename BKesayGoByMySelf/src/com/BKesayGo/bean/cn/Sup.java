/**
 *
 */
package com.BKesayGo.bean.cn;

/**
 * @author Renjianyong
 *
 */
public class Sup {
    /* 创建大分类表tb_sup */
    // create table tb_sup(
    // s_supid int(11) not null primary key,
    // s_supname varchar(30) not null,
    // create_man int not null,
    // create_time datetime,
    // constraint fk_pa foreign key(create_man) references admin(id)
    // );
    private int    s_supid;
    private String s_supname;
    private int    create_man;
    
    public int getCreate_man() {
        return create_man;
    }
    
    public void setCreate_man(int create_man) {
        this.create_man = create_man;
    }
    
    // private Admin admin;
    private String create_time;
    
    public int getS_supid() {
        return s_supid;
    }
    
    public void setS_supid(int s_supid) {
        this.s_supid = s_supid;
    }
    
    public String getS_supname() {
        return s_supname;
    }
    
    public void setS_supname(String s_supname) {
        this.s_supname = s_supname;
    }
    
    
    public String getCreate_time() {
        return create_time;
    }
    
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    
    
}
