package com.itcast.po;

import java.util.List;

/**
 *  用户包装类型
 *
 */
public class UserQueryVo {

	// 在这里包装所需要的查询条件
	
	// 用户查询的条件
	private UserCusTom userCusTom;
	// 传入多个id
	private List<Integer> ids;

	public UserCusTom getUserCusTom() {
		return userCusTom;
	}

	public void setUserCusTom(UserCusTom userCusTom) {
		this.userCusTom = userCusTom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	// 包装其他的查询条件  商品、订单。。。
	
}
