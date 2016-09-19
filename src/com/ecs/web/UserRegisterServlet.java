package com.ecs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecs.bean.User;
import com.ecs.common.exception.UserServiceException;
import com.ecs.service.IUserService;
import com.ecs.service.impl.UserServiceImpl;

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Integer age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		//封装对象
		User use=new User();
		use.setName(username);
		use.setPassword(password);
		use.setAge(age);
		use.setGender(gender);
		//调用service代码，完成业务逻辑
		IUserService service=new UserServiceImpl();
		try{
			service.register(use);
			//页面跳转
			request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		}catch(UserServiceException e){
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}
