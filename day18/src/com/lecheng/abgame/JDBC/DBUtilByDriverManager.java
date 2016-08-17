/**
 *
 */
package com.lecheng.abgame.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**
 * @author renjianyong
 *
 *         使用Driver的管理类进行数据库的连接
 */
public class DBUtilByDriverManager {

    private static final String URL = "jdbc:mysql://localhost:3306/renjianyong";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 获取数据库连接
    public static Connection getConnection() throws Exception {
        // 声明数据库连接
        Connection conn = null;
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("数据库连接成功！");
        return conn;
    }

    // 测试数据库是否正确连接
    @Test
    public void testConnection() {
        try {
            getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
