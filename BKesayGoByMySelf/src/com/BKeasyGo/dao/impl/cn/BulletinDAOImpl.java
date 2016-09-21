package com.BKeasyGo.dao.impl.cn;

import java.util.List;

import com.BKeasyGo.dao.cn.BulletinDao;
import com.BKeasyGo.helper.cn.BeanCreator;
import com.BKesayGo.bean.cn.Bulletin;

public class BulletinDAOImpl implements BulletinDao {

    /***
     * 普通查询
     * 
     * @param condition
     * @param params
     * @return
     */
    @Override
    public List<Bulletin> getBulletinAll(String condition, Object... params) {
        // 创建Beans
        BeanCreator creator = new BeanCreator();
        String sql = "select * from tb_bulletin" + (condition == null ? "" : condition);
        List<Bulletin> bs = creator.getBean(Bulletin.class, sql, params);
        return bs;
    }

    /***
     * 分页查询
     * 
     * @param page
     * @return
     */
    @Override
    public List<Bulletin> getBulletinByPage(int page) {

        String condition = " order by b_id DESC limit ?,?";

        List<Bulletin> bs = this.getBulletinAll(condition, (page - 1) * 5, 5);

        return bs;
    }

    /***
     * 获取总页数
     * 
     * @return
     */
    @Override
    public int getpageCount() {

        int pageTemp = this.getBulletinAll(null, null).size();
        int pageCount = 0;
        if (pageTemp > 0) {
            if (pageTemp % 5 != 0) {
                pageCount = (pageTemp / 5) + 1;
            } else {
                pageCount = (pageTemp / 5);
            }
        }
        return pageCount;
    }
}


