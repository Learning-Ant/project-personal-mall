package com.shoppingmall.command.addrbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingmall.common.PathNRedirect;

public interface M_AddrbookCommand {
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
