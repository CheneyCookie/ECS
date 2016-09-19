package com.ecs.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecs.bean.User;
import com.ecs.common.exception.UserServiceException;
import com.ecs.service.IUserService;
import com.ecs.service.impl.UserServiceImpl;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//获取单选框的值
		String remeber=request.getParameter("remeber");
		IUserService service=new UserServiceImpl();
		try {
			User use=service.login(username, password);
			//如果记住密码
			if(remeber!=null&&remeber.equals("ok")){
				System.out.println(username);
				String val=URLEncoder.encode(username+"|"+password,"UTF-8");
				//将编码后的用户名和密码保存到ecsUseInfo的cookie中，方便查找
				Cookie cookie=new Cookie("ecsUseInfo",val);
				System.out.println("cookie");
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			//获取session
			HttpSession session=request.getSession();
			//将当前登录的的用户信息存放到session中
			session.setAttribute("user", use);
			request.getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp").forward(request, response);
		} catch (UserServiceException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		}
	}

}
