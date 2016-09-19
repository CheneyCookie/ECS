package com.ecs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecs.bean.Administrator;
import com.ecs.common.exception.AdministratorServiceException;
import com.ecs.service.IAdministratorService;
import com.ecs.service.impl.AdministratorServiceImpl;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
		String password=request.getParameter("password");
		
		IAdministratorService administratorService=new AdministratorServiceImpl();
		try {
			Administrator admin=administratorService.login(adminname, password);
			//获取session
			HttpSession session=request.getSession();
			//将当前登录的用户信息存放到session中
			session.setAttribute("administrator", admin);
			if(admin.getName().equals("admin")){
				request.getRequestDispatcher("/WEB-INF/jsp/adminRegister.jsp").forward(request, response);
			}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (AdministratorServiceException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}
