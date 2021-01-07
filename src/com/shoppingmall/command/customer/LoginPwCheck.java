package com.shoppingmall.command.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.shoppingmall.dao.M_CustomerDao;
import com.shoppingmall.dto.M_CustomerDto;


@WebServlet("/LoginPwCheck")
public class LoginPwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginPwCheck() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		String m_customer_id = request.getParameter("m_customer_id");
		String m_customer_pw = request.getParameter("m_customer_pw");
		
		M_CustomerDto m_customerDto = new M_CustomerDto();
		m_customerDto.setM_customer_id(m_customer_id);
		m_customerDto.setM_customer_pw(m_customer_pw);
		
		M_CustomerDto loginDto = M_CustomerDao.getInstance().login(m_customerDto);
		
		JSONObject responseObj = new JSONObject();
		
		if(loginDto != null) {
			request.getSession().setAttribute("loginDto", loginDto);
			responseObj.put("result", true);
		} else {
			responseObj.put("result", false);
		}
		
		PrintWriter out = response.getWriter();
		out.println(responseObj);
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
