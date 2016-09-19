package com.BKeasyGo.dao.impl.cn;

import java.util.List;

import com.BKeasyGo.dao.cn.SubDAO;
import com.BKeasyGo.helper.cn.CreatBean;
import com.BKesayGo.bean.cn.Sub;

public class SubDAOImpl implements SubDAO {
    
    /***
     * 普通查询
     * 
     * @param condition
     * @param obj
     * @return
     */
    public List<Sub> getSubAll(String condition, Object[] obj) {
        String sql = "select * from tb_sub" + (condition == null ? "" : condition);
        // DBUtils db = new DBUtils();
        // List<Map<String, String>> subs = db.getQueryResultList(obj, sql);
        // 封装对象
        // List<Sub> targetList = new ArrayList<>();
        // Sub s = null;
        // for (Map<String, String> map : subs) {
        // s = new Sub();
        // s.setS_id(Integer.parseInt(map.get("s_id")));
        // s.setS_name(map.get("s_name"));
        // s.setCreate_man(Integer.parseInt(map.get("create_man")));
        // s.setS_supid(Integer.parseInt(map.get("s_supid")));
        // targetList.add(s);
        // }
        CreatBean creator = new CreatBean();
        List<Sub> subs = creator.getBean(Sub.class, sql);
        return subs;
    }
    
    
}
