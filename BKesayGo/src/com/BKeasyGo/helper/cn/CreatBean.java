package com.BKeasyGo.helper.cn;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.BKesayGo.Utils.cn.DBUtils;

public class CreatBean {
    
    public <T> List<T> getBean(Class<T> clazz, String sql, Object... params) {
        
        DBUtils db = new DBUtils();
        
        List<Map<String, String>> listTemp = db.getQueryResultList(params, sql);
        
        // 遍历集合封装Bean
        Set<String> names = listTemp.get(0).keySet();
        int namesCount = names.size();
        List<T> listTag = new ArrayList<>();
        for (Map<String, String> map : listTemp) {
            // 获取对应类的对象
            try {
                T targetBean = clazz.newInstance();
                // 获取目标类中所有的字段
                if (namesCount > 0) {
                    for (int i = 0; i < namesCount; i++) {
                        // 使用属性描述
                        PropertyDescriptor desc =
                                new PropertyDescriptor(names.toArray()[i].toString(), clazz);
                        Method set = desc.getWriteMethod();
                        Method get = desc.getReadMethod();
                        Type type = get.getGenericReturnType();
                        if ("int".equals(type.toString())) {
                            set.invoke(targetBean, Integer.parseInt(map.get(names.toArray()[i])));
                        } else {
                            set.invoke(targetBean, map.get(names.toArray()[i]));
                        }
                    }
                }
                listTag.add(targetBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return listTag;
    }
}
