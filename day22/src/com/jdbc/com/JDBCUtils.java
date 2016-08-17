/**
 *
 */
package com.jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author renjianyong
 *
 */
public class JDBCUtils {


    // 获取数据库连接

    public Connection getConn() { // 数据库连接对象
        Connection conn = null; // Statement对象
        Statement st = null;
        // 结果集对象
        ResultSet rs = null;
        // 查询语句
        String querySQL = "select * from emp";
        // 获取数据库连接驱动类
        final String url = "jdbc:mysql://localhost:3306/test";
        // 数据库连接用户名和密码
        final String user = "root";
        final String password = "123456";
        try { // 获取数据库连接对象
            conn = DriverManager.getConnection(url, user, password);
            // 获取Statement对象
            st = conn.createStatement();
            // 执行查询，返回结果集对象
            rs = st.executeQuery(querySQL);
            // 遍历结果集对象
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ":" + rs.getString(2) + "" + rs.getString(3) + ":"
                        + rs.getInt(4) + ":" + rs.getDate(5) + ":" + rs.getInt(6) + ":"
                        + rs.getInt(7) + ":" + rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
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
        return conn;
    }

    public static void main(String[] args) {
        JDBCUtils test = new JDBCUtils();
        test.getConn();
    }


    // 获取数据库连接方法
    public static Connection getConnection() {
        // 声明数据库连接对象
        Connection conn = null;
        // 连接数据库URL
        final String url = "jdbc:mysql://localhost:3306/temp?useSSL=false";
        // User
        final String user = "root";
        // Password
        final String password = "123456";
        // 获取数据库连接
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭资源方法
    public static void closeResource(ResultSet rs, PreparedStatement ps, Connection conn) {
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
}
