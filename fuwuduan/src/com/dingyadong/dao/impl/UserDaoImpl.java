package com.dingyadong.dao.impl;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.dingyadong.dao.UserDao;
import com.dingyadong.domain.User;
import com.dingyadong.utils.JDBCUtils;
 
public class UserDaoImpl implements UserDao {
 
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	/**
	 * dao�㣬�����ݿ�����ȡ������
	 */
	@Override
	public List<User> findAll() {
		List<User> list=null;
		try {
			//ͨ��������������
			connection = JDBCUtils.getConnetion();
			//ͨ�����Ӷ����ȡ�������ݿ�Ķ���
			String sql="SELECT * FROM user;";//��ѯsql���
			ps=connection.prepareStatement(sql);
			//���ز�ѯ�����
			rs=ps.executeQuery();
			//����rs������װ����
			list=new ArrayList<User>();
			while(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString(2));//������1��ʼ��id��������ȡ
				user.setPassword(rs.getString(3));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(connection, ps, rs);//�ر�����
			
		}
		return list;
	}
 
	@Override
	public void insertElement(User people) {
		try {
			connection=JDBCUtils.getConnetion();
			String sql="INSERT INTO user(username,password) VALUES(?,?);";//�������
			ps=connection.prepareStatement(sql);
			ps.setString(1,people.getUsername());//ʹ��prepareStatement���Է�ֹsqlע��
			ps.setString(2,people.getPassword());
			//ִ�и������
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.close(connection, ps, rs);
		}
	}
 
}