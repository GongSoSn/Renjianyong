/**
 *
 */
package com.test.cn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lecheng.abgame.JDBC.JDBCUtils;
import com.lecheng.abgame.bean.Player;
import com.lecheng.abgame.dao.DAO;
import com.lecheng.abgame.util.InputHelper;
import com.lecheng.abgame.util.SQLHelper;
import com.lecheng.abgame.util.checkUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author renjianyong
 *
 */
public class TestDemo {

    @Test
    public void test01() {
        String sql =
                "insert into game(g_name,g_count,g_countscore,g_countavg,g_gno,g_index) select s.pname g_name,s.count g_count,s.sumscore g_countscore,s.s_avg g_countavg,g_no g_gno,t_index g_index from t_grade g,(select name pname,count(s_id) count,sum(s_score) sumscore,AVG(s_score) s_avg from t_player p,t_score s where id = s_id group by s_id) as s where s.s_avg between l_value and h_value;";
        DAO dao = new DAO();
        int a = dao.update(sql);
        System.out.println(a);

    }

    @Test
    public void test02() throws Exception {
        String sql = "truncate table t_player";
        DAO dao = new DAO();
        Connection conn = JDBCUtils.getConnection();
        boolean b = dao.truncateData(conn, sql);
        System.out.println(b);

    }

    public PreparedStatement truncateData(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        boolean b = true;
        try {
            pstmt = conn.prepareStatement(sql);
            // 如果第一个结果是更新计数或者没有结果，则返回 false
            b = pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    // 测试数据库连接(从类路径中读取文件)
    @Test
    public void getConnTest() throws Exception {
        /*
         * 从类路径中读取文件(而不是根目录)
         */
        // InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        // Properties ps = new Properties();
        // ps.load(in);
        // System.out.println(ps.get("user"));
    }

    // 测试数据库连接(从根目录下读取文件)
    @Test
    public void getConnTest2() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }

    // 测试DAO
    @Test
    public void test3() {
        Connection conn = null;
        String sql1 = "set foreign_key_checks = 0";
        String sql2 = "truncate table t_player";
        try {
            conn = JDBCUtils.getConnection();
            truncateData(conn, sql1);
            truncateData(conn, sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(null, truncateData(conn, sql2), conn);
        }
    }

    // 测试c3p0连接数据源(常规)
    @Test
    public void testC3p0() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver"); // loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/abgame?useSSL=false");
        cpds.setUser("root");
        cpds.setPassword("123456");

        // 设置初始化数据池时，数据库连接的个数
        cpds.setInitialPoolSize(5);
        // 设置数据池中最大的数据库连接数
        cpds.setMaxPoolSize(5);
        // 获取数据库连接
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

    // 测试c3p0数据池连接
    @Test
    public void testC3p0ByXML() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("abgamec3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

    @Test
    public void testAllDelete() {
        Connection conn = null;
        String sql1 = "set foreign_key_checks = 0";
        String sql2 = "truncate table t_player";
        try {
            conn = JDBCUtils.getConnection();
            DAO dao = new DAO();
            dao.truncateData(conn, sql1);
            System.out.println(dao.truncateData(conn, sql2));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(null, truncateData(conn, sql2), conn);
        }
    }

    // 测试从外部文件中读取SQL
    @Test
    public void testGetSQLs() throws Exception {
        // Properties prop = new Properties();
        // InputStream in = new FileInputStream(new File("sqls.properties"));
        // prop.load(in);
        // String sql = prop.getProperty("SELECTE");
        // System.out.println(sql);
        String sql = SQLHelper.getSQL("selectAll_player");
        DAO dao = new DAO();
        List<Player> list = dao.getForList(Player.class, sql);
        for (Player p : list) {
            System.out.println(p);
        }
    }

    // 验证switch中能否使用continue？
    @Test
    public void testContinue() {
        int id = 99;
        int i = 1;
        String sql = "update t_player set ";
        boolean bb = true;
        String name = null;
        String pass = null;
        String nickName = null;
        String sex = null;
        int age = 0;
        List<Object> list = new ArrayList<>();
        while (bb) {
            switch (i) {
                case 1:
                    System.out.println("是否修改姓名？");
                    String yes = InputHelper.getString();
                    if (yes.equalsIgnoreCase("N")) {
                        i = 2;
                        continue;
                    } else {
                        System.out.println("请输入修改后的姓名：");
                        name = checkUtil.checkName();
                        sql += "name = ?";
                        list.add(name);
                    }
                case 2:
                    System.out.println("是否修改密码？");
                    String yes1 = InputHelper.getString();
                    if (yes1.equalsIgnoreCase("n")) {
                        i = 3;
                        continue;
                    } else {
                        System.out.println("请输入修改后的密码：");
                        pass = checkUtil.checkPass();
                        sql += "pass = ?";
                        list.add(pass);
                    }
                case 3:
                    System.out.println("是否修改昵称？");
                    String yes2 = InputHelper.getString();
                    if (yes2.equalsIgnoreCase("n")) {
                        i = 4;
                        continue;
                    } else {
                        System.out.println("请输入修改后的昵称：");
                        nickName = checkUtil.checkNickName();
                        sql += "nickname = ?";
                        list.add(nickName);
                    }
                case 4:
                    System.out.println("是否修改性别？");
                    String yes3 = InputHelper.getString();
                    if (yes3.equalsIgnoreCase("n")) {
                        i = 5;
                        continue;
                    } else {
                        System.out.println("请输入修改后的性别：");
                        sex = checkUtil.checkSex();
                        sql += "sex = ?";
                        list.add(sex);
                    }
                case 5:
                    System.out.println("是否修改年龄？");
                    String yes4 = InputHelper.getString();
                    if (yes4.equalsIgnoreCase("n")) {
                        bb = false;
                    } else {
                        System.out.println("请输入修改后的年龄：");
                        age = checkUtil.checkAge();
                        sql += "age = ?";
                        list.add(age);
                        bb = false;
                    }
            }

        }
        sql += " where id = " + id;
        System.out.println(sql);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

}
