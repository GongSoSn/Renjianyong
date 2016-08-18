/**
 *
 */
package com.dao.cn;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jdbc.com.JDBCUtils;

/**
 * @author renjianyong
 *
 */
public class Operation {

    // 更新操作(update,insert,delete)
    public void update(String sql, Object... args) {
        // 获取数据库连接
        Connection conn = JDBCUtils.getConnection();
        // 声明预编译PreparedStatement对象
        PreparedStatement ps = null;
        try {
            // 获取预编译PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 填充SQL中的占位符
            for (int i = 0, len = args.length; i < len; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行操作
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("操作执行成功，" + count + "条记录被更新！");
            } else {
                System.out.println("操作执行失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, conn);
        }
    }

    // 查询操作
    public <T> T query(Class<T> clazz, String sql, Object... args) {
        // 获取数据库连接
        Connection conn = JDBCUtils.getConnection();
        // 声明预编译语句对象PreparedStatement
        PreparedStatement ps = null;
        // 声明结果集对象
        ResultSet rs = null;
        // 需要封装的对象
        Object obj = null;
        try {
            // 获取预编译语句对象PreparedStatement
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0, len = args.length; i < len; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行查询并返回结果集
            rs = ps.executeQuery();
            // 遍历结果集，并实例化对象
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取ResultSet对象中数据的列数
            int columnCounts = rsmd.getColumnCount();
            while (rs.next()) {
                // 利用反射创建对象
                obj = clazz.newInstance();
                for (int i = 0; i < columnCounts; i++) {
                    // 获取ResultSet中数据的列名(已经在SQL中使用列别名使其与javaBean类中的属性名绑定)
                    String fieldName = rsmd.getColumnLabel(i + 1);
                    // 根据列名(属性名)查询结果集中对应的数据结果
                    Object fieldValue = rs.getObject(fieldName);
                    // 利用反射获取类中的属性名
                    Field f = clazz.getDeclaredField(fieldName);
                    // 判断属性的访问权限是不是‘public’
                    if (!(Modifier.isPublic(f.getModifiers()))) {
                        // 如果不是‘public’的访问权限，则设置能访问的权限
                        f.setAccessible(true);
                    }
                    // 利用反射进行对象的实例化(封装对象)
                    f.set(obj, fieldValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转型，返回想要的对象
        return (T) obj;
    }
}
