package com.shoppingmall.command.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingmall.common.PathNRedirect;

public class M_CustomerLogoutCommand implements M_CustomerCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.getSession().removeAttribute("loginDto");
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("/PersonalMall/index.jsp");
		pathNRedirect.setRedirect(true);
		return pathNRedirect;
	}

}
