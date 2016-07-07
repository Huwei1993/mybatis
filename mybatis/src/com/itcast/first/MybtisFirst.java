package com.itcast.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import org.junit.Test;

import com.itcast.po.User;

public class MybtisFirst {

	// 根据id查询用户信息，得到一条记录
	@Test
	public void FindUserByIdTest() throws IOException{
		
		//classpath:
		
		// mybatis的配置文件
		String resource = "config/SqlMapConfig.xml";
		
		InputStream isInputStream =  Resources.getResourceAsStream(resource);
		
		//创建回话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
		// 通过工厂得到Session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// selectOne(a,b)  a :映射文件中statement的id，等于=namespace+"."+statement的id 
		//                 b :指定和映射文件中所匹配的parameterType类型参数
		//  sqlSession.selectOneq的结果是与映射文件中所匹配的resultType类型的对象
		User user = sqlSession.selectOne("sys.findUserById", 1);
		System.out.println(user);
		// 释放资源
		sqlSession.close();
		
	}
	
	
	
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis的配置文件
				String resource = "config/SqlMapConfig.xml";
				
				InputStream isInputStream =  Resources.getResourceAsStream(resource);
				
				//创建回话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
				// 通过工厂得到Session
				SqlSession sqlSession = sqlSessionFactory.openSession();
				// 通过sqlSession操作数据库
				// selectOne(a,b)  a :映射文件中statement的id，等于=namespace+"."+statement的id 
				//                 b :指定和映射文件中所匹配的parameterType类型参数
				//  sqlSession.selectOneq的结果是与映射文件中所匹配的resultType类型的对象
				List<User>  userList = sqlSession.selectList("sys.findUserByName", "use"); 
				System.out.println(userList);
				// 释放资源
				sqlSession.close();
		
	}
	
	/**
	 *   插入用户
	 * @throws IOException
	 */
	@Test
	public void insertUserTest() throws IOException {
		// mybatis的配置文件
				String resource = "config/SqlMapConfig.xml";
				
				InputStream isInputStream =  Resources.getResourceAsStream(resource);
				
				//创建回话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
				// 通过工厂得到Session
				SqlSession sqlSession = sqlSessionFactory.openSession();
				// 通过sqlSession操作数据库
				// selectOne(a,b)  a :映射文件中statement的id，等于=namespace+"."+statement的id 
				//                 b :指定和映射文件中所匹配的parameterType类型参数
				//  sqlSession.selectOneq的结果是与映射文件中所匹配的resultType类型的对象
				
				// 插入用户的对象
				//  new String("人才班".getBytes("iso-8859-1"),"utf-8")
				User user = new User();
				user.setUsername("xiaojun");
				user.setSex("女");
				user.setAddress("江西南昌");
				sqlSession.insert("sys.insertUser",user); 
				System.out.println(user);
				// 释放资源
				sqlSession.commit();
				// 1-1 获取用户的信息主键（自增主键）
				
				System.out.println(user.getId());
				sqlSession.close();
		
	}
	
	 //  删除用户信息
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis的配置文件
				String resource = "config/SqlMapConfig.xml";
				
				InputStream isInputStream =  Resources.getResourceAsStream(resource);
				
				//创建回话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
				// 通过工厂得到Session
				SqlSession sqlSession = sqlSessionFactory.openSession();
				// 通过sqlSession操作数据库
				// selectOne(a,b)  a :映射文件中statement的id，等于=namespace+"."+statement的id 
				//                 b :指定和映射文件中所匹配的parameterType类型参数
				//  sqlSession.selectOneq的结果是与映射文件中所匹配的resultType类型的对象
				
				// 传入id，根据id删除用户
				User user = new User();
				
				sqlSession.delete("sys.deleteUser",17); 
				System.out.println(user);
				// 释放资源
				sqlSession.commit();
				sqlSession.close();
		
	}
	
	// 更新用户信息
	@Test
	public void updateUserTest() throws IOException {
				// mybatis的配置文件
				String resource = "config/SqlMapConfig.xml";
				
				InputStream isInputStream =  Resources.getResourceAsStream(resource);
				
				//创建回话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
				// 通过工厂得到Session
				SqlSession sqlSession = sqlSessionFactory.openSession();
				// 通过sqlSession操作数据库
				// selectOne(a,b)  a :映射文件中statement的id，等于=namespace+"."+statement的id 
				//                 b :指定和映射文件中所匹配的parameterType类型参数
				//  sqlSession.selectOneq的结果是与映射文件中所匹配的resultType类型的对象
				
				// 插入用户的对象
				//  new String("人才班".getBytes("iso-8859-1"),"utf-8")
				User user = new User();
				user.setId(13);
				user.setUsername("小军");
				user.setSex("男");
				user.setAddress("厦门");
				sqlSession.update("sys.updataUser",user); 
				System.out.println(user);
				// 释放资源
				sqlSession.commit();
				// 1-1 获取用户的信息主键（自增主键）
				
				System.out.println(user.getId());
				sqlSession.close();
		
	}
	
	
	
}
