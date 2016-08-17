/**
 *
 */
package com.lecheng.abgame.JDBC;

import org.junit.Test;

import com.lecheng.abgame.dao.DAO;
import com.lecheng.abgame.util.InputHelper;

/**
 * @author renjianyong
 *
 */
public class DBTest {

    // 测试数据是否连接成功
    @Test
    public void connTest() {
        try {
            DBUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试添加Student是否成功
    @Test
    public void updateTest() {
        // 拼接add SQL
        String addSQL = "INSERT INTO student VALUES(?,?,?)";
        // 设置参数
        System.out.println("请输入学生的ID：");
        int ID = InputHelper.getInt();
        System.out.println("请输入学生的姓名：");
        String name = InputHelper.getString();
        System.out.println("请输入学生的成绩：");
        int score = InputHelper.getInt();
        System.out.println(addSQL);
        DBUtils.updateStudent(addSQL, ID, name, score);
    }

    // 测试查询是否成功
    @Test
    public void queryTest() {
        System.out.println("请输出需要查询的ID：");
        int id = InputHelper.getInt();
        String sql = "select st_id id,st_name name,st_age age from student where st_id = ?";
        System.out.println(sql);
        DAO dao = new DAO();
        dao.qurey(Student.class, sql, id);
    }

    @Test
    public void deleteTest() {
        String deleteSQL = "delete from student where st_id = ?";
        System.out.println("请你输入需要删除的学生代号：");
        int ID = InputHelper.getInt();
        DBUtils.updateStudent(deleteSQL, ID);
    }

    @Test
    public void updateTest1() {
        String deleteSQL = "update student set st_name = ? where st_id = ?";
        System.out.println("请你输入需要删除的学生代号：");
        int ID = InputHelper.getInt();
        System.out.println("修改的内容是：");
        String name = InputHelper.getString();
        DBUtils.updateStudent(deleteSQL, name, ID);
    }
}
