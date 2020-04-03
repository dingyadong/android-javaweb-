package com.dingyadong.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
 
/**
 * ��ΪҪ����õ����µĲ��裬����дһ��������������jdbc
 * @author Justin
 *�����ﲻҪ�������import com.mysql.jdbc.PreparedStatement;�Ǵ��
 */
public class JDBCUtils {
	/**
	 * ���jdbc����
	 */
	static Connection connection=null;
	public static Connection getConnetion() throws Exception {
		//����jdbc����
		Class.forName("com.mysql.jdbc.Driver");
		//�����������ݿ��·��
		String url = "jdbc:mysql://localhost/android_login?user=root&password=228339726";
		//ͨ��url��������ݿ������
		connection = DriverManager.getConnection(url);
		return connection;
	}
	
	public static void close(Connection connection,PreparedStatement ps,ResultSet rs) {
		//һ��Ҫȷ���ر����ӣ����¹رղ����ǲ��չٷ��ĵ��ģ���Ȩ����
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}