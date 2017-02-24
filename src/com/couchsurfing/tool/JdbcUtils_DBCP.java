package com.couchsurfing.tool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;



public class JdbcUtils_DBCP {
	
	/**
     * ��java�У���д���ݿ����ӳ���ʵ��java.sql.DataSource�ӿڣ�ÿһ�����ݿ����ӳض���DataSource�ӿڵ�ʵ��
     * DBCP���ӳؾ���java.sql.DataSource�ӿڵ�һ������ʵ��
     */
    private static DataSource ds = null;
    //�ھ�̬������д������ݿ����ӳ�
    static{
        try{
            //����dbcpconfig.properties�����ļ�
            InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties prop = new Properties();
            prop.load(in);
            //��������Դ
            ds = BasicDataSourceFactory.createDataSource(prop);
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
    * @Method: getConnection
    * @Description: ������Դ�л�ȡ���ݿ�����
    * @Anthor:�°�����
    * @return Connection
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        //������Դ�л�ȡ���ݿ�����
        return ds.getConnection();
    }
    
    /**
    * @Method: release
    * @Description: �ͷ���Դ��
    * �ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����Statement���󣬴洢��ѯ�����ResultSet����
    * @Anthor:�°�����
    *
    * @param conn
    * @param st
    * @param rs
    */ 
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                //�رմ洢��ѯ�����ResultSet����
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //�رո���ִ��SQL�����Statement����
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //��Connection���Ӷ��󻹸����ݿ����ӳ�
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}