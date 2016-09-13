/**
 *
 */
package com.BKesayGo.Test.cn;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.BKeasyGo.dao.impl.cn.AdminDAOImpl;
import com.BKesayGo.Utils.cn.DBUtils;
import com.BKesayGo.bean.cn.Admin;

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
    public void queryTest() {

        // int[] ints = {1, 2, 3};

        List<Map<String, String>> list = db.getAdminList(new Object[2], "select * from admin");
        int count = list.size();
        if (list.size() > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println(list.get(i));
            }
        }
    }

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
}
