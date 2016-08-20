/**
 *
 */
package com.lecheng.abgame.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * @author renjianyong 获取连接任何数据库的通用连接
 */
public class JDBCUtils {
    /**
     * 声明数据库连接池对象，只有一个
     */
    private static DataSource dbcp = null;

    static {
        dbcp = new ComboPooledDataSource("abgamec3p0");
    }

    /**
     * 获取数据库连接对象(通过在数据库连接池中获取一个数据库连接实例)
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dbcp.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 处理数据库事务 1.开始事务
     */
    public static void beginTransaction(Connection conn) {
        if (conn != null) {
            try {
                // 修改数据库(MySQL)默认的提交方式
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理数据库事务 2.提交事务(必须关闭MySQL中默认的数据库提交方式)
     */
    public static void commit(Connection conn) {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理数据库事务 3.回滚事务
     */
    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     */
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
