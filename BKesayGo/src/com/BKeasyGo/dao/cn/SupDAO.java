package com.BKeasyGo.dao.cn;

import java.util.List;

import com.BKesayGo.bean.cn.Sup;

public interface SupDAO {
    List<Sup> getSupAll(String condition, Object[] obj);

    List<Sup> getSupByPage(int page);

    int getPageCount();

    int addSup(Sup s);
}
