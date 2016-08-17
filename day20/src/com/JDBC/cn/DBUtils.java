/**
 *
 */
package com.JDBC.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author renjianyong 数据库连接
 */
public class DBUtils {

    // 获取数据的连接对象
    public static Connection getConnection() {

        // 声明连接对象
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/renjianyong";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "123456";

        // 注册驱动
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库加载成功！！！！！");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
