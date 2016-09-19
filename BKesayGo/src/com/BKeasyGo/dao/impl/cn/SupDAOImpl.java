/**
 *
 */
package com.BKeasyGo.dao.impl.cn;

import java.util.List;

import com.BKeasyGo.dao.cn.SupDAO;
import com.BKeasyGo.helper.cn.CreatBean;
import com.BKesayGo.Utils.cn.DBUtils;
import com.BKesayGo.bean.cn.Sup;

/**
 * @author Renjianyong
 *
 */
public class SupDAOImpl implements SupDAO {
    
    /***
     * 普通查询‘大分类’
     * 
     * @param obj
     * @return
     */
    @Override
    public List<Sup> getSupAll(String condition, Object[] obj) {
        String sql = "select * from tb_sup" + (condition == null ? "" : condition);
        // DBUtils db = new DBUtils();
        // Sup sup = null;
        // List<Map<String, String>> list = db.getQueryResultList(obj, sql);
        // List<Sup> supList = new ArrayList<>();
        // for (Map<String, String> map : list) {
        // sup = new Sup();
        // sup.setS_supid(Integer.parseInt(map.get("s_supid")));
        // sup.setS_supname(map.get("s_supname"));
        // supList.add(sup);
        // }
        CreatBean creator = new CreatBean();
        
        List<Sup> sups = creator.getBean(Sup.class, sql, obj);
        
        return sups;
    }
    
    /***
     * 分页查询
     * 
     * @param page
     * @return
     */
    @Override
    public List<Sup> getSupByPage(int page) {
        String condition = " order by s_supid DESC limit ?,?";
        Object[] obj = {(page - 1) * 5, 5};
        List<Sup> supList = this.getSupAll(condition, obj);
        return supList;
    }
    
    /***
     * 查询总页数
     * 
     * @return
     */
    @Override
    public int getPageCount() {
        int pageCount = 0;
        int countTemp = this.getSupAll(null, null).size();
        if (countTemp > 0) {
            if (countTemp % 5 != 0) {
                pageCount = (countTemp / 5) + 1;
            } else {
                pageCount = countTemp / 5;
            }
        }
        return pageCount;
    }
    
    @Override
    public int addSup(Sup s) {
        String sql = "insert into tb_sup values(null,?,?,now());";
        Object[] obj = {s.getS_supname(), s.getCreate_man()};
        DBUtils db = new DBUtils();
        int count = db.update(sql, obj);
        return count;
    }
}


