package com.shoppingmall.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shoppingmall.dto.M_CustomerDto;
import com.shoppingmall.mybatis.config.DBService;

public class M_CustomerDao {
	private SqlSessionFactory factory;
	
	private M_CustomerDao() {
		factory=DBService.getInstance().getFactory();
	}
	
	// singleton
	private static M_CustomerDao m_customerDao = new M_CustomerDao();
	public static M_CustomerDao getInstance() {
		return m_customerDao;
	}
	
	// method
	public M_CustomerDto login(M_CustomerDto m_customerDto) {
		SqlSession ss = factory.openSession();
		M_CustomerDto loginDto = ss.selectOne("com.shoppingmall.mybatis.mapper.customer.login", m_customerDto);
		ss.close();
		return loginDto;
	}
}
