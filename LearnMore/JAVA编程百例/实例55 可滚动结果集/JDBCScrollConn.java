import java.sql.*;
/**
 * <p>Title: ODBC连接数据库</p>
 * <p>Description: 本实例演示如何使用JDBC桥操作数据库。</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Filename: JDBCScrollConn.java</p>
 * @author 杜江
 * @version 1.0
 */
public class JDBCScrollConn{
  private static String url="";
  private static String username="";
  private static String password="";
/**
 *<br>方法说明：获得数据连接
 *<br>输入参数：
 *<br>返回类型：Connection 连接对象
 */  
  public Connection conn(){
     try {
     	//加载JDBC驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //创建数据库连接
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }catch(SQLException sqle){
    	System.out.println("can't connection db:"+sqle);
    	return null;
    } catch (Exception e) {
        System.out.println("Failed to load JDBC/ODBC driver.");
        return null;
     }
  }
/**
 *<br>方法说明：执行查询SQL语句
 *<br>输入参数：Connection con 数据库连接
 *<br>输入参数：String sql 要执行的SQL语句
 *<br>返回类型：
 */
  public void query(Connection con, String sql){
    try{
     if(con==null){
       throw new Exception("database connection can't use!");
     }
     if(sql==null) throw new Exception("check your parameter: 'sql'! don't input null!");
     //声明语句
     Statement stmt = con.createStatement();
     //执行查询
     ResultSet rs = stmt.executeQuery(sql); 
     ResultSetMetaData rmeta = rs.getMetaData();
     //获得数据字段个数
     int numColumns = rmeta.getColumnCount();
     while(rs.next())
	 {
	   for(int i = 0;i< numColumns;i++)
	   {
		String sTemp = rs.getString(i+1);
		System.out.print(sTemp+"  ");
	   }
	  System.out.println("");	
	 }
    }catch(Exception e){
      System.out.println("query error:"+e);
    }
  }
/**
 *<br>方法说明：执行查询SQL语句
 *<br>输入参数：Connection con 数据库连接
 *<br>输入参数：String sql 要执行的SQL语句
 *<br>输入参数：pageNo  页码数
 *<br>输入参数：pageSize  记录条数
 *<br>返回类型：
 */
  public void query(Connection con, String sql,int pageNo,int pageSize){
    try{
     if(con==null){
       throw new Exception("database connection can't use!");
     }
     if(sql==null) throw new Exception("check your parameter: 'sql'! don't input null!");
     int intRowCount;//记录总数
     int intPageCount;//总页数
     //声明语句
     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     //执行查询
     ResultSet rs = stmt.executeQuery(sql); 
     ResultSetMetaData rmeta = rs.getMetaData();
     //获得数据字段个数
     int numColumns = rmeta.getColumnCount();
     //获取记录总数  
     rs.last();  
     intRowCount = rs.getRow(); 
     //记算总页数  
     intPageCount = (intRowCount+pageSize-1) / pageSize;
	 //调整待显示的页码  
     if(pageNo>intPageCount) pageNo = intPageCount; 

	 if(intPageCount>0){
     //将记录指针定位到待显示页的第一条记录上  
     rs.absolute((pageNo-1) * pageSize + 1); 
     int i = 0;
     while(i<pageSize && !rs.isAfterLast())
	 {
	   for(int j = 0;j< numColumns;j++)
	   {
		String sTemp = rs.getString(j+1);
		System.out.print(sTemp+"  ");
	   }
	   i++;
	   rs.next();
	  System.out.println("");	
	 }
	}
    }catch(Exception e){
      System.out.println("query error:"+e);
    }
  }
/**
 *<br>方法说明：执行插入、更新、删除等没有返回结果集的SQL语句
 *<br>输入参数：Connection con 数据库连接
 *<br>输入参数：String sql 要执行的SQL语句
 *<br>返回类型：
 */
   public void execute(Connection con, String sql){
    try{
     if(con==null) return;
     Statement stmt = con.createStatement();
    stmt.executeUpdate(sql); 

   }catch(Exception e){
      System.out.println("query error:"+e);
    }
  }
/**
 *<br>方法说明：
 *<br>输入参数：
 *<br>返回类型：
 */
  public void demo(int pageNo,int pageSize){
    try{
      JDBCScrollConn jc = new JDBCScrollConn();
      Connection conn = jc.conn();
      String sql = "select * from TBL_USER order by id";
      jc.query(conn,sql,pageNo,pageSize);
      conn.close();
    }catch(SQLException se){
      System.out.println(se);
    }catch(Exception e){
      System.out.println(e);
    }
    
  }
/**
 *<br>方法说明：主方法
 *<br>输入参数：
 *<br>返回类型：
 */
  public static void main(String[] arg){
    if(arg.length!=5){
      System.out.println("use: java JDBCScrollConn url username password NoPage PageSize");
      return;
    }
    JDBCScrollConn jsc = new JDBCScrollConn();
    jsc.url = arg[0];
    jsc.username=arg[1];
    jsc.password=arg[2];
    int nopage = Integer.parseInt(arg[3]);
    int pagesize = Integer.parseInt(arg[4]);
    jsc.demo(nopage,pagesize);
  }
} 