package com.BKeasyGo.dao.impl.cn;

import java.util.List;

import com.BKeasyGo.dao.cn.SubDAO;
import com.BKeasyGo.helper.cn.BeanCreator;
import com.BKesayGo.Utils.cn.DBUtils;
import com.BKesayGo.bean.cn.Sub;

public class SubDAOImpl implements SubDAO {

    /***
     * 普通查询 || ==>直接返回 sub 对象的Beans
     * 
     * @param condition
     * @param obj
     * @return
     */
    @Override
    public List<Sub> getSubAll(String condition, Object[] obj) {
        String sql = "select * from tb_sub" + (condition == null ? "" : condition);
        BeanCreator creator = new BeanCreator();
        List<Sub> subs = creator.getBean(Sub.class, sql, obj);
        return subs;
    }

    /***
     * 分页查询
     */
    @Override
    public List<Sub> getSubByPage(int page) {
        // 调用普通查询方法
        String condition = " order by  s_id DESC limit ?,?";
        Object[] obj = {(page - 1) * 5, 5};
        List<Sub> subs = this.getSubAll(condition, obj);
        return subs;
    }

    /***
     * 获取总页数
     * 
     * @return
     */
    @Override
    public int getPageCount() {

        int pageTemp = this.getSubAll(null, null).size();
        int pageCount = 0;
        if (pageTemp > 0) {
            if (pageTemp % 5 != 0) {
                pageCount = (pageTemp / 5) + 1;
            } else {
                pageCount = pageTemp / 5;
            }
        }
        return pageCount;
    }

    public int addSub(Sub sub) {
        int updateCount = 0;
        // insert into tb_sub values(null,'戴尔电脑',3,2,'2012-09-08');
        String sql = "insert into tb_sub values(null,?,?,?,now());";
        Object[] obj = {sub.getS_name(), sub.getS_supid(), sub.getCreate_man()};
        // 调用update方法
        DBUtils db = new DBUtils();
        updateCount = db.update(sql, obj);
        return updateCount;
    }
}


