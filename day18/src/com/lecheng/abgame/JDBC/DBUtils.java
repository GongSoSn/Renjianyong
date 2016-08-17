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
public class DBUtils {

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
        System.out.println("数据库连接成功！");
        return conn;
    }

    // 关闭打开资源
    // 关闭资源
    public static void closeResourse(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        // 判断是否为空
        if (null != rs) {
            try {
                rs.close();
                // System.out.println("ResultSet关闭！");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (null != pstmt) {
            try {
                pstmt.close();
                // System.out.println("PreparedStatement关闭！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
                // System.out.println("Connection关闭！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // 数据插入更新操作(update delete,insert)
    public static void updateStudent(String sql, Object... args) {

        // 获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            // 创建preparedStatement对象
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0, len = args.length; i < len; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行update操作
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("操作成功，" + count + " 条数据被更新 ！");
            } else {
                System.out.println("操作失败 ！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 不管执行成功与否，必须关闭打开的资源
        } finally {
            closeResourse(null, ps, conn);
        }

    }

    // 数据查询
    public static void queryOperation(int id) {
        // 获取数据库连接对象
        String querySQL = "select * from student where st_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        Student st = null;
        try {
            conn = getConnection();
            // 获取查询的集合
            // 填充占位符
            ps = conn.prepareStatement(querySQL);
            ps.setInt(1, id);
            System.out.println(querySQL);
            set = ps.executeQuery();

            while (set.next()) {
                st = new Student(Integer.parseInt(set.getString(1)), set.getString(2),
                        Integer.parseInt(set.getString(3)));
                System.out.println(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResourse(set, ps, conn);
        }
    }
}
