package com.itcast.dao;

import java.util.List;

import com.itcast.po.User;

public interface UserDao {

	//  根据id查找用户信息
	public User findUserById(int id) throws Exception ;
	
	//根据用户名模糊查询
	public List<User> finduserByName(String name) throws Exception;
	
	// 根据id删除数据
	public void deleteUserById(int id) throws Exception;
	
	// 根据id添加数据
	public void insertUser(User user) throws Exception;
		
	// 根据id更新数据
	public void updateUser(User user) throws Exception;
		
	
	
	
}
