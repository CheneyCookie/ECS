package com.ecs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecs.bean.Administrator;
import com.ecs.common.exception.AdministratorServiceException;
import com.ecs.service.IAdministratorService;
import com.ecs.service.impl.AdministratorServiceImpl;

@WebServlet("/adminRegister")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String adminname=request.getParameter("adminname");
		String password=request.getParameter("password");
		//封装对象
		Administrator admin=new Administrator();
		admin.setName(adminname);
		admin.setPassword(password);
		//调用service层代码完成业务逻辑
		IAdministratorService service=new AdministratorServiceImpl();
		try{
			service.register(admin);
			request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		}catch(AdministratorServiceException e){
			e.printStackTrace();
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}
