package com.dingyadong.test;



import java.util.List;

import org.junit.Test;
import  com.dingyadong.dao.UserDao;
import  com.dingyadong.dao.impl.UserDaoImpl;
import  com.dingyadong.domain.User;
 
class TestDao {
 
	/**
	 * 测试类，测试dao层那两个方法是否查询和插入正确
	 */
	@Test
	void testFindAll() {
		UserDao dao=new UserDaoImpl();
		List<User> list = dao.findAll();
		for(int i=0;i<list.size();i++) {//遍历list
			User user=list.get(i);
			System.out.println("username:"+user.getUsername());
			System.out.println("password:"+user.getPassword());
		}
	}
	@Test
	void testInsertElement() {
		UserDao dao=new UserDaoImpl();
		User people=new User();
		people.setUsername("hhhhh");
		people.setPassword("66666");
		dao.insertElement(people);
	}
 
}