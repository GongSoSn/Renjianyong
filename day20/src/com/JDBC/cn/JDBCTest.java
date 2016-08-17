/**
 *
 */
package com.JDBC.cn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author renjianyong c
 */
public class JDBCTest {



    // 增
    public void addStudent(String sql) {
        // 获取数据库连接
        Connection conn = DBUtils.getConnection();
        Statement stmt = null;
        int count = 0;
        try {
            // 创建一个Statement对象，将SQL发送到数据库
            stmt = conn.createStatement();
            // 执行操作
            count = stmt.executeUpdate(sql);

            if (count > -1) {
                System.out.println("添加成功了" + count + "条数据!");
            } else {
                System.out.println("添加失败！");
            }

            // 关闭statement对象
            stmt.close();
            // 关闭数据连接
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 删
    public void deleteStudent(String sql) {
        // 获取数据库连接
        Connection conn = DBUtils.getConnection();
        try {
            Statement s = conn.createStatement();

            int count = s.executeUpdate(sql);

            if (count > -1) {
                System.out.println("删除成功了" + count + "条数据！");
            } else {
                System.out.println("删除失败！");
            }

            s.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 改
    public void updateStudent(String sql) {
        // 获取数据库连接
        Connection conn = DBUtils.getConnection();
        try {
            Statement s = conn.createStatement();

            int count = s.executeUpdate(sql);

            if (count > -1) {
                System.out.println("修改成功了" + count + "条数据！");
            } else {
                System.out.println("修改失败！");
            }

            s.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查
    public void queryStudent(String sql) {
        // 获取数据库连接
        Connection conn = DBUtils.getConnection();
        Student student = new Student();

        try {
            Statement s = conn.createStatement();

            ResultSet set = s.executeQuery(sql);

            while (set.next()) {
                student.setSt_id(Integer.parseInt(set.getString(1)));
                student.setSt_name(set.getString(2));
                student.setSt_age(Integer.parseInt(set.getString(3)));
            }
            System.out.println(student);
            s.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
