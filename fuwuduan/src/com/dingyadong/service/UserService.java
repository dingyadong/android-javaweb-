package com.dingyadong.service;



import com.dingyadong.domain.User;
 
public interface UserService {
	//�����¼
	public String checkLogin(User user);
	//ע���û�
	public String register(User user);
}