package com.shoppingmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingmall.command.customer.M_CustomerCommand;
import com.shoppingmall.command.customer.M_CustomerLogoutCommand;
import com.shoppingmall.common.PathNRedirect;


@WebServlet("*.customer")
public class M_CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public M_CustomerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		M_CustomerCommand command = null;
		
		PathNRedirect pathNRedirect = null;
		
		try {
			switch(cmd) {
			// 커맨드
			case "/m_customerLogoutPage.customer" :
				command = new M_CustomerLogoutCommand();
				pathNRedirect = command.execute(request, response);
				break;
			// 단순이동
			case "/m_customerLoginPage.customer" :
				pathNRedirect = new PathNRedirect();
				pathNRedirect.setPath("m_customer/loginPage.jsp");
				pathNRedirect.setRedirect(false);
				break;
			case "/m_customerSignUpPage.customer" :
				pathNRedirect = new PathNRedirect();
				pathNRedirect.setPath("m_customer/signUpPage.jsp");
				pathNRedirect.setRedirect(false);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String path = pathNRedirect.getPath();
		boolean isRedirect = pathNRedirect.isRedirect();
		if (isRedirect) {
			response.sendRedirect(path);
		} else {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
