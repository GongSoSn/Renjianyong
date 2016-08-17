/**
 *
 */
package com.JDBCTest.cn;


import org.junit.Test;

import com.bean.cn.Department;
import com.dao.cn.Operation;
import com.jdbc.com.InputHelper;

/**
 * @author renjianyong
 *
 */
public class JDBCTest {

    @Test
    public void test01() {
        String sql = "insert into dept values(?,?,?)";
        System.out.print("输入需要插入的ID:");
        int id = InputHelper.getInt();
        System.out.print("输入需要插入的部门名称：");
        String name = InputHelper.getString();
        System.out.print("输入需要插入的部门所在地：");
        String location = InputHelper.getString();

        Operation op = new Operation();
        op.update(sql, id, name, location);
    }

    @Test
    public void test02() {
        String sql = "delete from dept where deptno = ?";
        System.out.print("输入想要删除的ID:");
        int id = InputHelper.getInt();
        Operation op = new Operation();
        op.update(sql, id);
    }

    @Test
    public void test03() {
        String sql = "update dept set dname = ? where deptno = 1002";
        System.out.print("输入修改后的名称：");
        String name = InputHelper.getString();
        Operation op = new Operation();
        op.update(sql, name);
    }

    @Test
    public void test04() {
        String sql = "select deptno dId,dname dname,loc location from dept where deptno = ?";
        System.out.print("输入想要查询的ID:");
        int id = InputHelper.getInt();
        Operation op = new Operation();
        Department dept = op.query(Department.class, sql, id);
        System.out.println(dept);
    }
}


