package com.itcast.po;
/**
 * 版权： 胡伟
 * @author 胡伟
 * @sub内容：订单的扩展类 通过此类映射订单用户查询的结果，让此类继承子段较多的pojo类
 * @Time :2016年7月5日  @时间 下午11:12:49
 */
public class OrdersCusTom  extends Orders{
	// 添加用户属性
	/**
	 * User.username
	 * User.sex
	 * User.address
	 */
	
	private String userName;
	private String sex;
	private String address;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrdersCusTom [userName=" + userName + ", sex=" + sex
				+ ", address=" + address + "]";
	}
	


}
