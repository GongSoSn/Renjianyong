/**
 *
 */
package com.BKeasyGo.dao.impl.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.BKeasyGo.dao.cn.UserDAO;
import com.BKesayGo.Utils.cn.DBUtils;
import com.BKesayGo.bean.cn.Sysuser;

/**
 * @author Renjianyong
 *
 */
public class UserDAOImpl implements UserDAO {

    /***
     * 查询 user
     */
    @Override
    public List<Sysuser> getAllUsers(String condition, Object[] obj) {
        String sql = "select * from tb_sysuser where 1=1" + (condition == null ? "" : condition);
        System.out.println(sql);
        // Object[] obj = {};
        DBUtils db = new DBUtils();
        Sysuser user = null;
        List<Sysuser> userList = new ArrayList<>();
        List<Map<String, String>> users = db.getQueryResultList(obj, sql);
        // 遍历map
        for (Map<String, String> map : users) {
            user = new Sysuser();
            user.setS_id(Integer.parseInt(map.get("s_id")));
            user.setS_username(map.get("s_username"));
            user.setS_truename(map.get("s_truename"));
            user.setS_sex(Integer.parseInt(map.get("s_sex")));
            user.setS_email(map.get("s_email"));
            user.setS_phone(map.get("s_phone"));
            user.setS_if(Integer.parseInt(map.get("s_if")));
            userList.add(user);
        }
        return userList;
    }

    /***
     * 根据page获取查询结果
     */
    public List<Sysuser> getUsersByPage(int page) {
        String condition = " order by s_id DESC limit ?,?";
        Object[] obj = {(page - 1) * 5, 5};
        List<Sysuser> usersListByPage = this.getAllUsers(condition, obj);
        return usersListByPage;
    }

    /***
     * 获取page count
     * 
     * @return
     */
    public int getPageCount() {
        int tempCount = 0;
        List<Sysuser> list = this.getAllUsers(null, null);

        int listCount = list.size();

        if (listCount > 0) {
            if ((listCount % 5) != 0) {
                tempCount = (listCount / 5) + 1;
            } else {
                tempCount = listCount / 5;
            }
        }
        return tempCount;
    }

    @Override
    public int addUser(Sysuser user) {
        String sql = "insert into tb_sysuser values(null,?,?,?,?,?,?,?,?,?,?,?,now(),null,null)";
        Object[] obj = {user.getS_username(), user.getS_truename(), user.getS_pwd(),
                user.getS_sex(), user.getS_birth(), user.getS_idcard(), user.getS_email(),
                user.getS_phone(), user.getS_address(), user.getS_if(), user.getCreate_man()};
        int count = 0;
        // 调用
        DBUtils db = new DBUtils();
        count = db.update(sql, obj);
        return count;
    }
}
