package com.itcast.po;

import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 *  
 *
 */
public class User {
	// 属性名和数据库表的字段对应
	private String sex;
	private int id;
	private String username;
	private String address;
	
	private Data birthday;
	
	private List<Orders> orderslist;
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Data getBirthday() {
		return birthday;
	}
	public void setBirthday(Data birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<Orders> getOrderslist() {
		return orderslist;
	}
	public void setOrderslist(List<Orders> orderslist) {
		this.orderslist = orderslist;
	}

	
	@Override
	public String toString() {
		return "User [sex=" + sex + ", id=" + id + ", username=" + username
				+ ", adderess=" + address + ", birthday=" + birthday+ ", orderslist=" + orderslist + "]";
	}
	
	
	
	

}
