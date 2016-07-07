package mapper;

import java.util.List;

import com.itcast.po.User;
import com.itcast.po.UserCusTom;
import com.itcast.po.UserQueryVo;

public interface UserMapper {

	/*用户信息综合查询*/
	public List<UserCusTom> findUserList(UserQueryVo queryVo) throws Exception;
	// 用户信息的综合查询总数
	public int findUserCount(UserQueryVo queryVo) throws Exception;
	
	// 根据id查询用户的信息，使用resultMap输出
	public User findUserByIdResultMap( int id) throws Exception;
	
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
