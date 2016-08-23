/**
 *
 */
package com.lecheng.abgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lecheng.abgame.JDBC.JDBCUtils;
import com.lecheng.abgame.reflection.ReflectionUtils;

/**
 * @author renjianyong
 *
 *         数据库访问层：创建用于数据库操作的通用类
 */
public class DAO {

    // update(INSERT,UPDATE,DELETE)
    public int update(String sql, Object... args) {
        Connection conn = null;
        // 预编译语句处理对象
        PreparedStatement ps = null;
        //
        int count = 0;
        try {
            // 获取数据库连接对象
            conn = JDBCUtils.getConnection();
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            if (args != null) {
                // 填充预编译语句中的占位符
                for (int i = 0, len = args.length; i < len; i++) {
                    if (args[i] != null) {
                        ps.setObject(i + 1, args[i]);
                    }
                }
            }
            // 执行更新语句
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.closeResourse(null, ps, conn);
        }
        return count;
    }

    /*
     * 清空表数据
     *
     */
    public boolean truncateData(Connection conn, String sql) throws Exception {
        PreparedStatement pstmt = null;
        boolean b = true;
        pstmt = conn.prepareStatement(sql);
        // 如果第一个结果是更新计数或者没有结果，则返回 false
        b = pstmt.execute();
        return b;
    }

    // 查询操作(返回一个对应目标对象)
    public <T> T getForSingle(Class<T> clazz, String sql, Object... args) {
        List<T> list = this.getForList(clazz, sql, args);
        T result = null;
        if (list.size() > 0) {
            result = list.get(0);
        }
        return result;
    }

    // 查询操作(返回多个对应目标对象)
    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        // 存放目标对象的List
        List<T> list = new ArrayList<>();
        Connection conn = null;
        // PreparedStatement SQL 预编译对象
        PreparedStatement ps = null;
        // 结果集对象
        ResultSet rs = null;
        try {
            // 建立数据库连接
            conn = JDBCUtils.getConnection();
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 判断是不是查询全部
            if (args.length != 0) {
                // 填充占位符
                for (int i = 0, len = args.length; i < len; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            // 执行操作 得到结果集
            rs = ps.executeQuery();
            // 存放所有目标对象的Map
            List<Map<String, Object>> listDB = handleResultSet(rs);
            // 遍历Map，实例化对象
            list = getObject(clazz, listDB);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.closeResourse(rs, ps, conn);
        }
        // 转换为目标对象的类型(传递过来的此方法中未知)
        return list;
    }

    // 处理查询结果
    public List<Map<String, Object>> handleResultSet(ResultSet rs) {
        // 存放所有目标对象的Map
        List<Map<String, Object>> list = new ArrayList<>();
        // 声明目标对象
        Map<String, Object> values = null;
        // 获取元数据
        ResultSetMetaData metaDate;
        try {
            metaDate = rs.getMetaData();

            while (rs.next()) {
                // 遍历结果集 放在Map中
                values = new HashMap<String, Object>();
                for (int i = 0, len = metaDate.getColumnCount(); i < len; i++) {
                    String columnLabel = metaDate.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(metaDate.getColumnLabel(i + 1));
                    values.put(columnLabel, columnValue);
                }
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 遍历Map,实例化对象
    @SuppressWarnings("unchecked")
    public <T> List<T> getObject(Class<T> clazz, List<Map<String, Object>> values)
            throws Exception {
        List<T> list = new ArrayList<>();
        if (values.size() > 0) {
            for (Map<String, Object> map : values) {
                Object obj = clazz.newInstance();
                for (Map.Entry<String, Object> entity : map.entrySet()) {
                    String fieldName = entity.getKey();
                    Object fieldValue = entity.getValue();
                    // 封装对象
                    ReflectionUtils.setFieldValue(obj, fieldName, fieldValue);
                }
                list.add((T) obj);
            }
        }
        return list;
    }
}
