package iml;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import mapper.OrdersMapperCusTom;
import mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itcast.Daoimpl.UserDaoImpl;
import com.itcast.dao.UserDao;
import com.itcast.po.Orders;
import com.itcast.po.OrdersCusTom;
import com.itcast.po.User;
import com.itcast.po.UserCusTom;
import com.itcast.po.UserQueryVo;

public class UserDaoImplTest {

	
	private SqlSessionFactory sqlSessionFactory;
	//此方法在执行testFindUserById之前先执行的
	@Before
	public void setUp() throws Exception{
		// 创建SqlsessionFactory
		String resource = "config/SqlMapConfig.xml";
		
		InputStream isInputStream =  Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(isInputStream);
		
		
	}
	
	// 用户信息的综合查询
	
	@Test
	public void testFindUserList() throws Exception  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCusTom userCusTom = new UserCusTom();
		// 由于使用了动态sql，如果不设置某个值，条件不会被拼接到sql语句当中
		userCusTom.setSex("男");
		userCusTom.setUsername("user");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		// 将ids传入statement中
		userQueryVo.setIds(ids);
		userQueryVo.setUserCusTom(userCusTom);
		List<UserCusTom> list = userMapper.findUserList(userQueryVo);
		
		if (list.isEmpty()) {
			System.out.println("查询的数据不存在！！");
		}else {
			System.out.println(list);
		}
		
	}
	
	@Test
	public void testFindUserCount() throws Exception  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCusTom userCusTom = new UserCusTom();
		userCusTom.setSex("男");
		userCusTom.setUsername("user");
		userQueryVo.setUserCusTom(userCusTom);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(1);
		System.out.println(user);
		
	}

	@Test
	public void testfindUserByIdResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdResultMap(1);
		System.out.println(user);
		
	}
	
	@Test
	public void testfindOrdersUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCusTom ordersMapperCusTom = sqlSession.getMapper(OrdersMapperCusTom.class);
		
		List<OrdersCusTom> list = ordersMapperCusTom.findOrdersUser();
		System.out.println(list);
	}
	
	// 查询订单关联用户使用resultMap
	@Test
	public void	testfindOrderUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCusTom ordersMapperCusTom = sqlSession.getMapper(OrdersMapperCusTom.class);
		List<Orders> list = ordersMapperCusTom.findOrderUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	
	//  查询订单及订单明细
		@Test
		public void	testfindOrderAndOrderDetailResultMap() throws Exception {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			OrdersMapperCusTom ordersMapperCusTom = sqlSession.getMapper(OrdersMapperCusTom.class);
			List<Orders> list = ordersMapperCusTom.findOrderAndOrderDetailResultMap();
			System.out.println(list);
			sqlSession.close();
		}
		
		//查询用户购买的商品信息
		@Test
		public void	testfindUserAndItemsResultMap() throws Exception {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			OrdersMapperCusTom ordersMapperCusTom = sqlSession.getMapper(OrdersMapperCusTom.class);
			List<User> list = ordersMapperCusTom.findUserAndItemsResultMap();
			System.out.println(list);
			sqlSession.close();
		}
		
		//  查询订单关联查询用户
		@Test
		public void testfindOrdersUserLazyLoading() throws Exception{
			SqlSession sqlSession =sqlSessionFactory.openSession();
			OrdersMapperCusTom ordersMapperCusTom = sqlSession.getMapper(OrdersMapperCusTom.class);
			List<Orders> list = ordersMapperCusTom.findOrdersUserLazyLoading();
			System.err.println(list);
			sqlSession.close();
			
			
		}
	
	
}
