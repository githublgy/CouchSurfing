package com.couchsurfing.tool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class JdbcUnit {
	
	private static  String url= null;  
	private static  String name= null ;  
	private static  String user = null;  
	private static  String password= null;
	private volatile static JdbcUnit jdbcUnit;
	private JdbcUnit(){};
	
	public static JdbcUnit getInstance(){
		if(jdbcUnit==null){
			synchronized (JdbcUnit.class) {
				if (jdbcUnit==null) {
					jdbcUnit=new JdbcUnit();
				}
			}
		}
		return jdbcUnit;
	}
	
	static {
		loadProperties();
	}
	
	private static void loadProperties() {
		InputStream inputStream  =  JdbcUnit.class.getClassLoader().getResourceAsStream( "jdbc.properties" );    
		 Properties p  =   new  Properties();    
		  try   {    
			  p.load(inputStream);    
		   }   catch  (IOException e1)  {    
			   System.out.println("数据库参数加载错误");   
		  }
		  url =  p.getProperty("url" );
		  name = p.getProperty("driverClassName");
		  user = p.getProperty("username");
		  password = p.getProperty("password");
	}
	public Connection createConn() {
		Connection conn = null;
		try {
			Class.forName(name);
			conn = (Connection) DriverManager.getConnection(url, user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public  PreparedStatement prepare(Connection con, String sql) {
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	public  void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(conn!=null){
				conn.close();
				conn = null;	
			}
			
			if(ps!=null){
				ps.close();
				ps = null;
			}
			if (rs!= null) {
				rs.close();
				rs = null;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   


}
