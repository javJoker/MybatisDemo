package com.self.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.self.entity.Role;
import com.self.entity.User;
import com.self.utils.SessionUtil;

public class MybatisTest {
	//查询
	@Test
	public void show(){
		SqlSession session = null;
		try {	
			session = SessionUtil.buildSession();		
			List<User> userlist = session.selectList("UserMapper.show",null);
			for(User user : userlist){
				System.out.println(user);
			}
			session.commit();
		}finally{
			SessionUtil.closeSession(session);
		}
		
	}
	
	//通过id查询
	@Test
	public void showById(){
		SqlSession session = null;
		try {	
			session = SessionUtil.buildSession();
			User u = new User();
			//u.setId(1);
			u.setUsername("hah");
			List<User> userlist = session.selectList("UserMapper.showById",u);
			for(User user : userlist){
				System.out.println(user);
			}
			session.commit();
		}finally{
			SessionUtil.closeSession(session);
		}
		
	}
	
	//通过id,username查询
		@Test
		public void showByIdUsername(){
			SqlSession session = null;
			try {	
				session = SessionUtil.buildSession();
				User u = new User();
				/*u.setId(1);
				u.setUsername("hah");*/
				List<User> userlist = session.selectList("UserMapper.showByIdName",u);
				for(User user : userlist){
					System.out.println(user);
				}
				session.commit();
			}finally{
				SessionUtil.closeSession(session);
			}
			
		}
		
	
	//添加
	@SuppressWarnings("null")
	@Test
	public void add(){
		SqlSession session = null;
		try {
			
			session = SessionUtil.buildSession();
			
			User user = new User();
			user.setUsername("hah");
			user.setPassword("hah");
			user.setAge(2);
			session.selectList("UserMapper.add",user);
			session.commit();
		}finally{
			SessionUtil.closeSession(session);
		}
		
	}
	
	//添加list
	/*@SuppressWarnings("null")
	@Test
	public void addlist(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSessionFactory factory = null;
		
		SqlSession session = null;
		try {
			inputStream =Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
			session = factory.openSession();
			
			User user = new User();
			user.setUsername("enen");
			user.setPassword("enen");
			user.setAge(3);
			
			User user1 = new User();
			user1.setUsername("222");
			user1.setPassword("22");
			user1.setAge(4);
			
			List<User> list = new ArrayList<User>();
			session.selectList("UserMapper.addlist",list);
			session.commit();
		} catch (IOException e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}*/
	
	/*注意：运行下面的方法，需要到user类中把tosting方法注释掉*/
	@Test
	public void showRole(){
		SqlSession session = null;
		try {
			session = SessionUtil.buildSession();
			
			List<Role> rolelist = session.selectList("RoleMapper.showRole",null);
			for(Role role : rolelist){
				System.out.println(role);
			}
			session.commit();
		}finally{
			SessionUtil.closeSession(session);
		}
		
	}
}
