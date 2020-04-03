package com.dingyadong.web.control;



import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dingyadong.domain.User;
import com.dingyadong.service.UserService;
import com.dingyadong.service.impl.UserServiceImpl;
 
 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//�����������(post)
		response.setCharacterEncoding("UTF-8");//�����Ӧ����,����Ҫ���ַ�����������ֽ��������Ҫ�ٴα��룩
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sign=request.getParameter("sign");
		PrintWriter out=response.getWriter();
		//�Ѵ��������ݷ�װ��javabean��
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService service=new UserServiceImpl();
		if("1".equals(sign)) {//��¼����(������һ�����)
			String loginInfo=service.checkLogin(user);
			out.print(loginInfo);
		}
		else if("2".equals(sign)) {//ע�����
			String registerInfo=service.register(user);
			out.print(registerInfo);
		}
		
		System.out.println(username);//�ڿ���̨���
		System.out.println(password);
		System.out.println(sign);
		
	
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//�����������(post)
		response.setCharacterEncoding("UTF-8");//�����Ӧ����,����Ҫ���ַ�����������ֽ��������Ҫ�ٴα��룩
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sign=request.getParameter("sign");
		PrintWriter out=response.getWriter();
		//�Ѵ��������ݷ�װ��javabean��
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService service=new UserServiceImpl();
		if("1".equals(sign)) {//��¼����(������һ�����)
			String loginInfo=service.checkLogin(user);
			out.print(loginInfo);
		}
		else if("2".equals(sign)) {//ע�����
			String registerInfo=service.register(user);
			out.print(registerInfo);
		}
		
		System.out.println(username);//�ڿ���̨���
		System.out.println(password);
		System.out.println(sign);
	}
 

}