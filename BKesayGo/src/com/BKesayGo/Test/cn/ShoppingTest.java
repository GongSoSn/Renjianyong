/**
 *
 */
package com.BKesayGo.Test.cn;

import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.BKeasyGo.dao.impl.cn.AdminDAOImpl;
import com.BKeasyGo.helper.cn.CreatBean;
import com.BKesayGo.Utils.cn.DBUtils;
import com.BKesayGo.bean.cn.Admin;
import com.BKesayGo.bean.cn.Sup;

/**
 * @author Renjianyong 测试相关的类
 */
public class ShoppingTest {
    DBUtils db = new DBUtils();
    
    @Test
    public void connectionTest() {
        Connection conn = db.getConn();
        if (conn != null) {
            System.out.println("数据库连接成功!");
        }
    }
    
    @Test
    public void queryTest() {/*
                              * 
                              * // int[] ints = {1, 2, 3};
                              * 
                              * List<Map<String, String>> list = db.getAdminList(new Object[2],
                              * "select * from admin"); int count = list.size(); if (list.size() >
                              * 0) { for (int i = 0; i < count; i++) {
                              * System.out.println(list.get(i)); } }
                              */}
    
    @Test
    public void queryTest01() {
        AdminDAOImpl admin = new AdminDAOImpl();
        Object[] obj = {"Hurk", 123};
        List<Admin> list = admin.queryAdmin(obj);
        int count = list.size();
        if (list.size() > 0) {
            for (Admin a : list) {
                System.out.println(a.getManager());
            }
        }
    }
    
    @Test
    public void testCreatBean() {
        CreatBean create = new CreatBean();
        String sql = "select * from admin";
        List<Admin> admins = create.getBean(Admin.class, sql);
        if (admins.size() > 0) {
            for (Admin admin : admins) {
                System.out.println(admin.getTruename());
            }
        }
    }
    
    @Test
    public void testDesc() throws Exception {
        Admin admin = new Admin();
        PropertyDescriptor desc = new PropertyDescriptor("id", Admin.class);
        desc.getWriteMethod().invoke(admin, 1);
        System.out.println(admin.getId());
        System.out.println(desc.getReadMethod().getGenericReturnType());
    }
    
    @Test
    public void testSup() {
        String sql = "select * from tb_sup order by s_supid DESC limit 0,5";
        CreatBean creator = new CreatBean();
        
        List<Sup> sups = creator.getBean(Sup.class, sql);
        if (sups.size() > 0) {
            for (Sup admin : sups) {
                System.out.println(admin.getS_supname());
            }
        }
    }
}
