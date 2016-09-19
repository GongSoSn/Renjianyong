/**
 *
 */
package com.BKeasyGo.dao.impl.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.BKeasyGo.dao.cn.AdminDAO;
import com.BKesayGo.Utils.cn.DBUtils;
import com.BKesayGo.bean.cn.Admin;

/**
 * @author Renjianyong
 *
 */
public class AdminDAOImpl implements AdminDAO {

    DBUtils db = new DBUtils();

    @Override
    public List<Admin> queryAdmin(Object[] obj) {
        List<Map<String, String>> list = new ArrayList<>();
        List<Admin> admins = new ArrayList<>();
        Admin admin = null;
        String sql = "select * from admin where manager = ? and password = ?";
        list = db.getQueryResultList(obj, sql);
        int count = list.size();
        if (count > 0) {
            admin = new Admin();
            for (int i = 0; i < count; i++) {
                admin.setId(Integer.parseInt(list.get(i).get("id")));
                admin.setManager(list.get(i).get("manager"));
                admin.setPassword(list.get(i).get("password"));
                admin.setTruename(list.get(i).get("truename"));
            }
            admins.add(admin);
        }
        return admins;
    }
}
