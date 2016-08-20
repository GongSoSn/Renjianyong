/**
 *
 */
package com.lecheng.abgame.JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author renjianyong 获取连接任何数据库的通用连接
 */
public class JDBCUtils {

    // 连接数据库URL
    private static String url = null;
    // 用户和密码
    private static String user = null;
    private static String password = null;

    // 获取数据库连接对象
    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        // 加载配置文件
        props.load(new FileInputStream(new File("jdbc.properties")));
        // 加载数据库URL
        url = props.getProperty("url");
        // 加载用户和密码
        user = props.getProperty("user");
        password = props.getProperty("password");
        props.put("user", user);
        props.put("password", password);
        // 创建数据库连接对象
        Connection conn = DriverManager.getConnection(url, props);
        return conn;
    }

    // 关闭资源
    public static void closeResourse(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        // 判断是否为空
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (null != pstmt) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
