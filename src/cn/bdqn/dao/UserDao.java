package cn.bdqn.dao;

import cn.bdqn.domain.User;

public interface UserDao {

	/**添加用户*/
	public boolean insertUser(User user);
	/**用户登录*/
	public boolean getUser(String uid);
	/**检验用户名是否已存在*/
	public boolean isExist(String strAccount);
}
