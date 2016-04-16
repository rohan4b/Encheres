import java.sql.*;
public class MySql {
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	public static Connection getConnection()
	{
		Connection conn=null;
		try{
		  Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	       
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
