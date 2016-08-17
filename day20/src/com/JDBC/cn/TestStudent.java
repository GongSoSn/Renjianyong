/**
 *
 */
package com.JDBC.cn;

/**
 * @author renjianyong
 *
 */
public class TestStudent {

    public static void main(String[] args) {

        String insertSQL = "insert into student(st_name,st_age) values('科比',38)";
        String deleteSQL = "delete from student where st_id = 5";
        String querySQL = "select * from student";
        String updateSQL = "update student set st_name = '张无忌' where st_name = '林志玲'";

        JDBCTest test = new JDBCTest();

        test.addStudent(insertSQL);

        // test.deleteStudent(deleteSQL);
        //
        // test.updateStudent(updateSQL);

        test.queryStudent(querySQL);
    }

}
