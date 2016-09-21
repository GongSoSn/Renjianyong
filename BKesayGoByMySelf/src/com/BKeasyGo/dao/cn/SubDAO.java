package com.BKeasyGo.dao.cn;

import java.util.List;

import com.BKesayGo.bean.cn.Sub;

public interface SubDAO {

    List<Sub> getSubByPage(int page);

    List<Sub> getSubAll(String condition, Object[] obj);

    int getPageCount();

    int addSub(Sub sub);
}
