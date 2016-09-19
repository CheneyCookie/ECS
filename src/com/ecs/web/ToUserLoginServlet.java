package com.ecs.web;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/toUserLogin")
public class ToUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToUserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//当用户没有登录时，要判断浏览器是否浏览器记录了密码
			Cookie[] cookies=request.getCookies();
			String username=null;
			String password=null;
				for(Cookie cookie:cookies){
					if(cookie.getName().equals("ecsUseInfo")){
						String val=URLDecoder.decode(cookie.getValue(), "UTF-8");
						String[] arr=val.split("[|]");
						username=arr[0];
						password=arr[1];
						System.out.println(username);
						System.out.println("cookie2");
						request.setAttribute("uname",username);
						request.setAttribute("upassword", password);
					}
				}
			request.getRequestDispatcher("WEB-INF/jsp/userlogin.jsp").forward(request, response);
	}

}
