/**
 *
 */
package com.lecheng.abgame.JDBC;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.lecheng.abgame.dao.DAO;
import com.lecheng.abgame.util.InputHelper;

/**
 * @author renjianyong
 *
 */
public class JDBCTest {

    // 测试数据是否连接成功
    @Test
    public void connTest() {
        try {
            JDBCUtils.getConnection();
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
        // DBUtils.updateStudent(addSQL, ID, name, score);
    }

    // 测试查询是否成功(多条)
    @Test
    public void queryTest() {
        System.out.println("请输出需要查询的ID1：");
        int id1 = InputHelper.getInt();
        System.out.println("请输出需要查询的ID2：");
        int id2 = InputHelper.getInt();
        System.out.println("请输出需要查询的ID3：");
        int id3 = InputHelper.getInt();
        System.out.println("请输出需要查询的ID4：");
        int id4 = InputHelper.getInt();
        String sql = "select st_id id,st_name name,st_age age from student where st_id in(?,?,?,?)";
        System.out.println(sql);
        DAO dao = new DAO();
        List<Student> list = dao.getForList(Student.class, sql, id1, id2, id3, id4);
        // JDBCUtilsByOther t = new JDBCUtilsByOther();
        // List list = t.query(sql, null);
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // 测试查询是否成功(一条)
    @Test
    public void queryTest02() {
        System.out.println("请输出需要查询的ID1：");
        int id1 = InputHelper.getInt();
        String sql = "select st_id id,st_name name,st_age age from student where st_id = ?";
        System.out.println(sql);
        DAO dao = new DAO();
        Student st = dao.getForSingle(Student.class, sql, id1);
        System.out.println(st);
    }

    @Test
    public void deleteTest() {
        String deleteSQL = "delete from student where st_id = ?";
        System.out.println("请你输入需要删除的学生代号：");
        int ID = InputHelper.getInt();
        // DBUtils.updateStudent(deleteSQL, ID);
    }

    @Test
    public void updateTest1() {
        String deleteSQL = "update student set st_name = ? where st_id = ?";
        System.out.println("请你输入需要删除的学生代号：");
        int ID = InputHelper.getInt();
        System.out.println("修改的内容是：");
        String name = InputHelper.getString();
        // DBUtils.updateStudent(deleteSQL, name, ID);
    }
}
