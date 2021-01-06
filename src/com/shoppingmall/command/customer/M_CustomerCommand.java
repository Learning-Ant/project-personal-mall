package com.shoppingmall.command.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingmall.common.PathNRedirect;

public interface M_CustomerCommand {
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
