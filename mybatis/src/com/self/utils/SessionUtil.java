package com.self.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	public static String resource = "mybatis-config.xml";
	public static InputStream inputStream = null;
	public static SqlSessionFactory factory = null; 
	
	public static SqlSession buildSession(){
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			return factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeSession(SqlSession session){
		if(session != null)
			session.close();
	}
}
