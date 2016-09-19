package com.test.cn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;
import com.DBUtils.cn.DBUtils;
import com.bean.cn.Admin;

public class DBTest {

    DBUtils db = new DBUtils();
    public Connection conn;
    
    @Test
    public void connTest(){
        conn = db.getConn();
        if(conn != null){
            System.out.println("数据库连接成功!");
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void queryColumnsTest(){
        conn = db.getConn();
        String sql = "select * from admin";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
                ColumnListHandler<Admin> handler = new ColumnListHandler<>("truename");
                Object obj = handler.handle(rs);
                System.out.println(obj.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void queryRowsTest(){
        conn = db.getConn();
        String sql = "select * from admin";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayListHandler rowsHandler = new ArrayListHandler();
             List<Object[]> list = rowsHandler.handle(rs);
             for (Object[] obj : list) {
                 System.out.println(Arrays.toString(obj));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void mapListHandlerTest(){
        conn = db.getConn();
        String sql = "select * from admin";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            MapListHandler mapList = new MapListHandler();
            List<Map<String, Object>> list = mapList.handle(rs);
            for (Map<String, Object> map : list) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.print(entry + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void beanConvert(){

        conn = db.getConn();
        String sql = "select * from admin";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            BeanListHandler<Admin> handler = new BeanListHandler<>(Admin.class);
            List<Admin> admins = handler.handle(rs);
            for (Admin admin : admins) {
                System.out.println(admin.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    @Test
    public void ReflectionTest(){

        conn = db.getConn();
        String sql = "select s_id,s_username,s_truename,s_pwd,s_sex,s_birth,s_idcard,s_email,s_phone,s_address,s_if,create_man,create_time,update_man,update_time from tb_sysuser";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Class c = Admin.class;
            
            Admin a = null;
//            c.getDeclaredField(name);
            
            ResultSetMetaData rsmd =  rs.getMetaData();
            int count = rsmd.getColumnCount();
            while(rs.next()){
                a = new Admin();
                for(int i = 1;i <= count; i ++){
                    String name = rsmd.getColumnLabel(i);
                    Field f = c.getDeclaredField(name);
                   
                    if(Modifier.isPublic( f.getModifiers())){
                        f.set(a, rs.getObject(name));
                    }else {
                       f.setAccessible(true);
                       f.set(a, rs.getObject(name));
                    }
                }
                System.out.println(a.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
