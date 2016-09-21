package com.BKeasyGo.dao.cn;

import java.util.List;

import com.BKesayGo.bean.cn.Bulletin;

public interface BulletinDao {
    List<Bulletin> getBulletinAll(String condition, Object... params);

    List<Bulletin> getBulletinByPage(int page);

    int getpageCount();
}
