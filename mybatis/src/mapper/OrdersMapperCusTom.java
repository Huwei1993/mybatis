package mapper;

import java.util.List;

import com.itcast.po.Orders;
import com.itcast.po.OrdersCusTom;
import com.itcast.po.User;

public interface OrdersMapperCusTom {

	// 查询订单关联查询用户信息
	public List<OrdersCusTom> findOrdersUser() throws  Exception;
	
	// 查询订单关联用户使用resultMap
	public List<Orders>  findOrderUserResultMap() throws Exception;
	
	// 查询订单及订单明细
	public List<Orders> findOrderAndOrderDetailResultMap() throws Exception;
	
	// 查询用户购买的商品信息
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	// 查询订单关联查询用户 延迟加载
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
	
}
