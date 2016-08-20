/**
 *
 */
package com.lecheng.abgame.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author renjianyong
 *
 */
public class JDBCUtilsByOther {


    // 查询方法
    public List<Map<String, String>> query(String sql, Object... args) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        // 声明PreparedStatement 预编译对象
        PreparedStatement ps = null;
        // 声明结果集对象
        ResultSet rs = null;
        try {
            Connection conn = JDBCUtils.getConnection();
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0, len = args.length; i < len; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行操作，返回结果集
            rs = ps.executeQuery();
            // 获取元数据对象
            ResultSetMetaData rmsd = rs.getMetaData();
            // 遍历结果集
            while (rs.next()) {
                map = new HashMap<>();
                for (int i = 0, len = rmsd.getColumnCount(); i < len; i++) {
                    map.put(rmsd.getColumnLabel(i + 1), rs.getString(i + 1));
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
