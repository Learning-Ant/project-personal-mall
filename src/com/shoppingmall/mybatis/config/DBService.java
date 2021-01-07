package com.shoppingmall.mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {

	// DBService : SqlSessionFactory 객체를 만들어서 반환하는 클래스
	
	// 필드
	private SqlSessionFactory factory;
	
	// DBService 생성자 : Singleton
	private DBService() {
		try {
			String resource = "com/shoppingmall/mybatis/config/sqlmap-config.xml"; // sqlmap-config의 경로 (sqlmap-config.xml이 resource다.)
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static DBService service = new DBService();
	public static DBService getInstance() {
		return service;
	}
	
	public SqlSessionFactory getFactory() {
		return factory;
	}
	// factory얻기 -> DBService.getInstance().getFactory();
}