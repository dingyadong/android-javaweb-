package com.dingyadong.service.impl;

import java.util.List;
 
import com.dingyadong.dao.UserDao;
import com.dingyadong.dao.impl.UserDaoImpl;
import com.dingyadong.domain.User;
import com.dingyadong.service.UserService;
 
public class UserServiceImpl implements UserService {
 
	UserDao dao=new UserDaoImpl();
	
	/*
	 * 主要的逻辑实现
	 */
	@Override
	public String checkLogin(User user) {
		List<User> list = dao.findAll();
		for(int i=0;i<list.size();i++) {//遍历集合
			User user2=list.get(i);
			if(user2.getUsername().equals(user.getUsername()) && user2.getPassword().equals(user.getPassword())) {
				System.out.println("登陆成功");
				return "登录成功";
			}
		}
		return "登录失败,密码输入错误";
	}
 
	@Override
	public String register(User user) {
		List<User> list = dao.findAll();
		for(int i=0;i<list.size();i++) {
			User user2=list.get(i);
			if(user2.getUsername().equals(user.getUsername())) {
				return "注册失败，该用户名已存在！";
			}
		}
		dao.insertElement(user);
		return "注册成功";
	}
 
}