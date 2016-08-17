/**
 *
 */
package com.lecheng.abgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import com.lecheng.abgame.JDBC.DBUtils;
import com.lecheng.abgame.reflection.ReflectionUtils;

/**
 * @author renjianyong
 *
 *         数据库访问层：创建用于数据库操作的通用类
 */
public class DAO {

    // update(INSERT,UPDATE,DELETE)
    public void update(String sql, Object... args) {
        // 数据库连接对象
        Connection conn = null;
        // 预编译语句处理对象
        PreparedStatement ps = null;
        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 填充预编译语句中的占位符
            for (int i = 0, len = args.length; i < len; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行更新语句
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("操作成功，更新了" + count + "记录！");
            } else {
                System.out.println("操作失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtils.closeResourse(null, ps, conn);
        }
    }

    // 查询操作
    public <T> T qurey(Class<T> clazz, String sql, Object... args) {
        // 数据库连接对象
        Connection conn = null;
        // PreparedStatement对象
        PreparedStatement ps = null;
        // 结果集对象
        ResultSet rs = null;
        try {
            // 建立数据库连接
            conn = DBUtils.getConnection();
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0, len = args.length; i < len; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行操作 得到结果集
            rs = ps.executeQuery();
            // 获取元数据
            ResultSetMetaData metaDate = rs.getMetaData();
            // 遍历结果集 放在Map中
            Map<String, Object> values = new HashMap<String, Object>();
            while (rs.next()) {
                for (int i = 0, len = metaDate.getColumnCount(); i < len; i++) {
                    String columnLabel = metaDate.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(metaDate.getColumnLabel(i + 1));
                    values.put(columnLabel, columnValue);
                }
            }
            Object obj = clazz.newInstance();
            // 遍历Map，实例化对象
            for (Map.Entry<String, Object> entity : values.entrySet()) {
                String fieldName = entity.getKey();
                Object fieldValue = entity.getValue();
                ReflectionUtils.setFieldValue(obj, fieldName, fieldValue);
            }
            System.out.println(obj);
        } catch (

        Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtils.closeResourse(rs, ps, conn);
        }
        return null;
    }
}
