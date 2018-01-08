package com.qianfeng.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import com.mysql.jdbc.Driver;

public class JDBCUtils {
	private static String driverClass = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	static{
		//��õ�ǰ�����ڵ������ĵ���������������������·���µ�dbinfo.properties�����ļ���
		/*InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbinfo.properties");
		Properties p = new Properties();
		try {
			p.load(is);
			driverClass = p.getProperty("driverClass");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			//��������
			Class.forName(driverClass);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ���Connection���Ӷ���
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	/**
	 * �ر���Դ   new  MyConnection()
	 */
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
