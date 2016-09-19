/**
 *
 */
package com.BKeasyGo.dao.cn;

import java.util.List;

import com.BKesayGo.bean.cn.Sysuser;

/**
 * @author Renjianyong
 *
 */
public interface UserDAO {
    List<Sysuser> getAllUsers(String condition, Object[] obj);

    int addUser(Sysuser user);
}
