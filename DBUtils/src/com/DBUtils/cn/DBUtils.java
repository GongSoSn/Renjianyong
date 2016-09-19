package com.DBUtils.cn;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;

public class DBUtils {
    private DBUtils db;
    private Connection conn;
    
    public Connection getConn(){
        final String user = "root";
        final String password = "123456";
        final String url = "jdbc:mysql:///shopping?useSSL=false";
        //加载驱动类
        DbUtils.loadDriver("com.mysql.jdbc.Driver");
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
