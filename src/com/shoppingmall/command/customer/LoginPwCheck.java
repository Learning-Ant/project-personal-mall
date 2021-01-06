package com.shoppingmall.command.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		boolean result = M_CustomerDao.getInstance().login(m_customerDto);
		
		JSONObject data = new JSONObject();
		
		if (result) {
			data.put("result", result);
			data.put("m_customer_id", m_customer_id);
			data.put("m_customer_pw", m_customer_pw);
		} else {
			data.put("result", result);
		}
		
		PrintWriter out = response.getWriter();
		out.println(data);
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
