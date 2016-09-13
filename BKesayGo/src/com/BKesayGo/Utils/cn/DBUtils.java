/**
 *
 */
package com.BKesayGo.Utils.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.ResultSetMetaData;

/**
 * @author Renjianyong 数据库访问工具类
 */

public class DBUtils {
    private final String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
    private final String user = "root";
    private final String password = "123456";
    private final String driver = "com.mysql.jdbc.Driver";

    private Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    // 获取数据库连接对象
    public Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭数据库相关资源
    public void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // update
    public int update(String sql, Object[] obj) {
        conn = this.getConn();
        int count = 0;
        try {
            if (obj != null) {
                ps = conn.prepareStatement(sql);
                for (int i = 0, len = obj.length; i < len; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
                count = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResources(null, ps, conn);
        }
        return count;
    }

    // Query
    public List<Map<String, String>> getAdminList(Object[] obj, String sql) {
        conn = this.getConn();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        try {
            if (obj != null) {
                ps = conn.prepareStatement(sql);
                for (int i = 0, len = obj.length; i < len; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
                rs = ps.executeQuery();
                ResultSetMetaData rsdm = (ResultSetMetaData) rs.getMetaData();
                int count = rsdm.getColumnCount();
                if (count > 0) {
                    while (rs.next()) {
                        map = new HashMap<String, String>();
                        for (int i = 1; i <= count; i++) {
                            map.put(rsdm.getColumnLabel(i), rs.getObject(i) + "");
                        }
                        list.add(map);
                    }
                }
            }
        } catch (

        SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
