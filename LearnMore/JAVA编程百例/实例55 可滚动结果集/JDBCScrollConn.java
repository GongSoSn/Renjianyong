import java.sql.*;
/**
 * <p>Title: ODBC�������ݿ�</p>
 * <p>Description: ��ʵ����ʾ���ʹ��JDBC�Ų������ݿ⡣</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Filename: JDBCScrollConn.java</p>
 * @author �Ž�
 * @version 1.0
 */
public class JDBCScrollConn{
  private static String url="";
  private static String username="";
  private static String password="";
/**
 *<br>����˵���������������
 *<br>���������
 *<br>�������ͣ�Connection ���Ӷ���
 */  
  public Connection conn(){
     try {
     	//����JDBC����
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //�������ݿ�����
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
 *<br>����˵����ִ�в�ѯSQL���
 *<br>���������Connection con ���ݿ�����
 *<br>���������String sql Ҫִ�е�SQL���
 *<br>�������ͣ�
 */
  public void query(Connection con, String sql){
    try{
     if(con==null){
       throw new Exception("database connection can't use!");
     }
     if(sql==null) throw new Exception("check your parameter: 'sql'! don't input null!");
     //�������
     Statement stmt = con.createStatement();
     //ִ�в�ѯ
     ResultSet rs = stmt.executeQuery(sql); 
     ResultSetMetaData rmeta = rs.getMetaData();
     //��������ֶθ���
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
 *<br>����˵����ִ�в�ѯSQL���
 *<br>���������Connection con ���ݿ�����
 *<br>���������String sql Ҫִ�е�SQL���
 *<br>���������pageNo  ҳ����
 *<br>���������pageSize  ��¼����
 *<br>�������ͣ�
 */
  public void query(Connection con, String sql,int pageNo,int pageSize){
    try{
     if(con==null){
       throw new Exception("database connection can't use!");
     }
     if(sql==null) throw new Exception("check your parameter: 'sql'! don't input null!");
     int intRowCount;//��¼����
     int intPageCount;//��ҳ��
     //�������
     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     //ִ�в�ѯ
     ResultSet rs = stmt.executeQuery(sql); 
     ResultSetMetaData rmeta = rs.getMetaData();
     //��������ֶθ���
     int numColumns = rmeta.getColumnCount();
     //��ȡ��¼����  
     rs.last();  
     intRowCount = rs.getRow(); 
     //������ҳ��  
     intPageCount = (intRowCount+pageSize-1) / pageSize;
	 //��������ʾ��ҳ��  
     if(pageNo>intPageCount) pageNo = intPageCount; 

	 if(intPageCount>0){
     //����¼ָ�붨λ������ʾҳ�ĵ�һ����¼��  
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
 *<br>����˵����ִ�в��롢���¡�ɾ����û�з��ؽ������SQL���
 *<br>���������Connection con ���ݿ�����
 *<br>���������String sql Ҫִ�е�SQL���
 *<br>�������ͣ�
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
 *<br>����˵����
 *<br>���������
 *<br>�������ͣ�
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
 *<br>����˵����������
 *<br>���������
 *<br>�������ͣ�
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