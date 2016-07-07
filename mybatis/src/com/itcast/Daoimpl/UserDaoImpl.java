package com.itcast.Daoimpl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itcast.dao.UserDao;
import com.itcast.po.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;
//  private SqlSession sqlsession;  写在这里不安全，所以必须写在方法内部
	
	String resource = "config/SqlMapConfig.xml";
	
	
	
	public UserDaoImpl(SqlSessionFactory sessionFactory){
		this.sqlSessionFactory = sessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		User  user = sqlsession.selectOne("sys.findUserById",id);
		// 释放资源
		sqlsession.close();
		if (user !=null) {
			return user;	
		}else{
			System.out.println("您查询的数据不存在！请重新输入。。");
			return null;
		}
		
	}

	@Override
	public List<User> finduserByName(String name) throws Exception {
		
		InputStream isInputStream =  Resources.getResourceAsStream(resource);
		
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
		// 通过工厂得到Session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// selectOne(a,b)  a :映射文件中statement的id，等于=namespace+"."+statement的id 
		//                 b :指定和映射文件中所匹配的parameterType类型参数
		//  sqlSession.selectOneq的结果是与映射文件中所匹配的resultType类型的对象
		List<User>  userList = sqlSession.selectList("sys.findUserByName", name); 
		System.out.println(userList);
		// 释放资源
		sqlSession.close();
		return userList;
		
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		SqlSession  sqlsession = sqlSessionFactory.openSession();
		sqlsession.delete("sys.deleteUser",id);
		sqlsession.commit();
		// 释放资源
		sqlsession.close();
		
	}

	@Override
	public void insertUser(User user) throws Exception{
		SqlSession  sqlsession = sqlSessionFactory.openSession();
		// 执行插入
		sqlsession.insert("sys.insertUser",user);
		// 释放资源
		sqlsession.commit();
		 
		 // 释放资源
		sqlsession.close();
		
		
	}

	@Override
	public void updateUser(User user) throws Exception {
		SqlSession  sqlsession = sqlSessionFactory.openSession();
		// 执行插入
		sqlsession.insert("sys.updataUser",user);
		// 释放资源
		sqlsession.commit();
		 
		 // 释放资源
		sqlsession.close();
		
	}

}
